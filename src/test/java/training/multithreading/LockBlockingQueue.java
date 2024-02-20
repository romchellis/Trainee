package training.multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBlockingQueue implements BlockingQueue {
    private final int size;
    private Queue<Integer> queue;

    private Lock lock = new ReentrantLock(true);
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public LockBlockingQueue(int size) {
        this.queue = new ArrayDeque<>(size);
        this.size = size;
    }

    @Override
    public Integer take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            Integer remove = queue.remove();
            notFull.signalAll();
            return remove;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    @Override
    public void push(Integer i) {
        lock.lock();
        try {
            if (queue.size() == size) {
                notFull.await();
            }
            queue.add(i);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        var queue = new SemaphoreBlockingQueue(100);

        var producer = new Thread(

                () -> {
                    while (true) {
                        int i = new Random().nextInt();
                        queue.push(i);

                        System.out.println(Thread.currentThread() + " added: " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        var producer2 = new Thread(
                () -> {
                    while (true) {
                        int i = new Random().nextInt();
                        queue.push(i);
                        System.out.println(Thread.currentThread() + " added: " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        var consumer = new Thread(
                () -> {
                    while (true) {
                        Integer take = queue.take();
                        System.out.println(Thread.currentThread() + " get: " + take);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

//        select count(*) sc from employee e
//        left join
//        action a
//        on e.id = a.employee_id
//        group by score
//        having sc > 100

        var consumer2 = new Thread(
                () -> {
                    while (true) {
                        Integer take = queue.take();
                        System.out.println(Thread.currentThread() + " get: " + take);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        producer.setName("producer1");
        producer.start();
        producer2.setName("producer2");
        producer2.start();
        consumer.setName("consumer2");
        consumer.start();
//        consumer2.start();
    }
}
