package training.multithreading;

import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Boolean fooPrinted = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();
            while (fooPrinted) {
                condition.await();
            }

            // printBar.run() outputs "bar". Do not change or remove this line.
            printFoo.run();
            fooPrinted = true;
            condition.signalAll();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            while (!fooPrinted) {
                condition.await();
            }


            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooPrinted = false;
            condition.signalAll();
            lock.lock();
        }
    }

}
