package training.multithreading;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPong {
    private Boolean pinged = true;
    private final Lock lock = new ReentrantLock();
    private final Condition pingCondition = lock.newCondition();
    private final Condition pongCondition = lock.newCondition();

    public void ping() {
        try {
            lock.lock();
            while (!pinged) {
                pingCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + ": ping");
            Thread.sleep(100);
            pinged = false;
            pongCondition.signal();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pong() {
        try {
            lock.lock();
            while (pinged) {
                pongCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + ": pong");
            Thread.sleep(100);
            pinged = true;
            pingCondition.signal();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public synchronized void ping() {
//        try {
//            while (!pinged) {
//                wait();
//            }
//            System.out.println(Thread.currentThread().getName() + ": ping");
//            Thread.sleep(100);
//            pinged = false;
//            notifyAll();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public synchronized void pong() {
//        try {
//            while (pinged) {
//                wait();
//            }
//            System.out.println(Thread.currentThread().getName() + ": pong");
//            Thread.sleep(100);
//            pinged = true;
//            notifyAll();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        var pp = new PingPong();
        var threads = List.of(
                new Pinger(pp),
                new Pinger(pp),
                new Ponger(pp),
                new Ponger(pp),
                new Ponger(pp),
                new Pinger(pp)
        );
    }

    static class Pinger extends Thread {
        private final PingPong pingPong;

        Pinger(PingPong pingPong) {
            this.pingPong = pingPong;
            start();
        }

        @Override
        public void run() {
            while (true) {
                pingPong.ping();
            }
        }
    }

    static class Ponger extends Thread {
        private final PingPong pingPong;

        Ponger(PingPong pingPong) {
            this.pingPong = pingPong;
            start();
        }

        @Override
        public void run() {
            while (true) {
                pingPong.pong();
            }
        }
    }

}
