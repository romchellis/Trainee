package training.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Method2CyclicBarrier {

    ExecutorService service;
    CyclicBarrier c1 = new CyclicBarrier(2);
    CyclicBarrier c2 = new CyclicBarrier(2);

    public static void main(String[] args) {
        Method2CyclicBarrier m = new Method2CyclicBarrier();
        m.runPingPong();
    }

    public void runPingPong() {
        service = Executors.newFixedThreadPool(2);
        service.submit(() -> {
            while (true) {
                this.printPing(c1, c2);
                TimeUnit.SECONDS.sleep(1);
            }
        });
        service.submit(() -> {
            while (true) {
                this.printPong(c1, c2);
                TimeUnit.SECONDS.sleep(1);
            }
        });
    }


    public void printPing(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            c1.await();
            System.out.println("PING");
            c2.await();
        } catch (InterruptedException | BrokenBarrierException ignored) {
        }
    }

    public void printPong(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            c1.await();
            c2.await();
            System.out.println("PONG");
        } catch (InterruptedException | BrokenBarrierException ignored) {
        }
    }
}
