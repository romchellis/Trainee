package training.multithreading;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountTransfering {

    //need to transfer from acc a to b ,
    public static void main(String[] args) {
        var transfering = new AccountTransfering();
        var accounts = IntStream.range(0, 2)
                .mapToObj(it -> {
                    BigInteger bigInteger = new BigInteger(String.valueOf(new Random().nextInt(1000)));
                    return new Account(it, bigInteger);
                })
                .collect(Collectors.toList());
        var executor = Executors.newFixedThreadPool(150);
        for (int i = 0; i < 100000; i++) {
            int finalI = i;
            executor.submit(() -> {
                var sum = new BigInteger(String.valueOf(new Random().nextInt(300)));
                if (finalI % 2 == 0) {
                    sum = sum.negate();
                }
                var firstIndex = new Random().nextInt(2);
                var secondIndex = 0;
                while (secondIndex == firstIndex) {
                    secondIndex = new Random().nextInt(2);
                }
                transfering.transfer(
                        accounts.get(firstIndex),
                        accounts.get(secondIndex),
                        sum
                );
            });
        }
        executor.shutdown();
    }


    public void transfer(Account from, Account to, BigInteger amount) {
        int firstId = from.getId();
        int secondId = to.getId();
        Runnable r = () -> {
            BigInteger amountOne = from.getAmount();
            BigInteger amountTwo = to.getAmount();

//            if (amountOne.compareTo(amountTwo) < 0) {
//                System.out.println("Error: " + amountOne + " is less than " + amountTwo);
//                return;
//            }

            System.out.println("transfer from: " + firstId + " with " + amountOne
                    + " to " + secondId + " with " + amountTwo
                    + " amount " + amount);
            var first = from.getAmount().subtract(amount);
            var second = to.getAmount().add(amount);
            from.setAmount(first);
            to.setAmount(second);
            System.out.println("thus " + firstId + " has " + from.getAmount()
                    + " and " + secondId + " has " + to.getAmount());
        };
        if (firstId < secondId) {
            from.lock.lock();
//            synchronized (from) {
            to.lock.lock();
            System.out.println("get lock " + from.getId());
//                synchronized (to) {
            System.out.println("get lock " + to.getId());
            r.run();
            from.lock.unlock();
            to.lock.unlock();
//                }

//            }
        } else {
//            synchronized (to) {
            from.lock.lock();
            System.out.println("get lock " + from.getId());
//                synchronized (from) {
            to.lock.lock();
            System.out.println("get lock " + to.getId());
            r.run();
            to.lock.unlock();
            from.lock.unlock();
//                }
//            }
        }
    }
}

class Account {
    public final Lock lock = new ReentrantLock();
    private BigInteger amount;
    private int id = 0;


    public Account(int id, BigInteger bigInteger) {
        this.id = id;
        amount = bigInteger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public Account(BigInteger amount) {
        this.amount = amount;
    }


    public BigInteger getAmount() {
        return amount;
    }
}
