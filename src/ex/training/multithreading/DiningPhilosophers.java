package ex.training.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DiningPhilosophers {

    private final Lock fooLock = new ReentrantLock();
    private final Lock barLock = new ReentrantLock();

    public static void main(String[] args) {
        var a = new DiningPhilosophers();
        var barrier = new CyclicBarrier(5);
        for (int c = 0; c < 5; c++) {
            final var i = c;
            new Thread(() -> {
                try {
                    barrier.await();
                    a.wantsToEat(i,
                            () -> {

                            },
                            () -> {

                            },
                            () -> System.out.println("philosopher: " + i + " is eating"),
                            () -> {

                            },
                            () -> {

                            });
                } catch (InterruptedException | BrokenBarrierException e) {
                }
            }).start();
        }
    }

    private final Semaphore[] forks = new Semaphore[5];

    public DiningPhilosophers() {
        var lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        if (philosopher == 3) {
            acquireForkLeftHanded(3, pickLeftFork, pickRightFork);
        } else {
            acquireForkForRightHanded(philosopher, pickLeftFork, pickRightFork);
        }

        eat.run();

        putRightFork.run();
        forks[philosopher].release();
        putLeftFork.run();
        forks[(philosopher + 1) % 5].release();
    }

    private void acquireForkForRightHanded(int id,
                                           Runnable pickLeftFork,
                                           Runnable pickRightFork) throws InterruptedException {
        forks[id].acquire();
        pickRightFork.run();
        forks[(id + 1) % 5].acquire();
        pickLeftFork.run();
    }

    private void acquireForkLeftHanded(int id,
                                       Runnable pickLeftFork,
                                       Runnable pickRightFork) throws InterruptedException {
        forks[(id + 1) % 5].acquire();
        pickLeftFork.run();
        forks[id].acquire();
        pickRightFork.run();
    }

}
