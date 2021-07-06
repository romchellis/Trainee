package ex.training.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTraining {
    private CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println(" Wall is " +
            "broken!"));

    public static void main(String[] args) {
        CyclicBarrierTraining cyclicBarrierTraining = new CyclicBarrierTraining();
        var executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 15; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.submit(cyclicBarrierTraining::attack);
        }
        executor.shutdown();
    }

    public void attack() {
        try {
            System.out.println(Thread.currentThread().getName() + " is attacking the wall");
            barrier.await();

            System.out.println(Thread.currentThread().getName() + " behind the wall!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
