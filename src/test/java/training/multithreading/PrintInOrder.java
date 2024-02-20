package training.multithreading;

import java.util.List;
import java.util.concurrent.Phaser;

public class PrintInOrder {
    private Phaser phaser;

    public PrintInOrder() {
        phaser = new Phaser(3);
    }

    public void first(Runnable printFirst) {
        phaser.arrive();
        phaser.awaitAdvance(0);

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        phaser.arrive();
        phaser.arrive();
    }

    public void second(Runnable printSecond) {
        phaser.arrive();
        phaser.awaitAdvance(0);
        phaser.arrive();
        phaser.awaitAdvance(1);

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        phaser.arrive();
    }

    public void third(Runnable printThird) {
        phaser.arrive();
        phaser.awaitAdvance(0);
        phaser.arrive();
        phaser.awaitAdvance(1);
        phaser.arrive();
        phaser.awaitAdvance(2);

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }

    public static void main(String[] args) {
        var inOrder = new PrintInOrder();
        for (int i = 0; i < 5; i++) {
            var threads = List.of(
                    new Thread(() -> inOrder.first(() -> {
                        System.out.println("first");
                    })),
                    new Thread(() -> inOrder.third(() -> {
                        System.out.println("third");
                    })),
                    new Thread(() -> inOrder.second(() -> {
                        System.out.println("second");
                    }))
            );
            threads.forEach(Thread::start);
        }

    }
}
