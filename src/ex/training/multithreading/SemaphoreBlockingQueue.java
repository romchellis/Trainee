package ex.training.multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class SemaphoreBlockingQueue implements BlockingQueue {

    private final Semaphore notEmpty;
    private final Semaphore notFull;
    private final Semaphore operationLock;
    private Queue<Integer> queue;

    public SemaphoreBlockingQueue(int size) {
        queue = new ArrayDeque(size);
        notEmpty = new Semaphore(0);
        operationLock = new Semaphore(1);
        notFull = new Semaphore(size);
    }

    @Override
    public void push(Integer i) {
        try {
            notFull.acquire();
//            operationLock.acquire();
//            synchronized (this) {
                queue.add(i);
//            }
//            operationLock.release();
            notEmpty.release();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    @Override
    public Integer take() {
        try {
            notEmpty.acquire();
            Integer poll;
//            operationLock.acquire();
//            synchronized (this) {
                poll = queue.poll();
//            }
//            operationLock.release();
            notFull.release();
            return poll;
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
        throw new RuntimeException();
    }
}
