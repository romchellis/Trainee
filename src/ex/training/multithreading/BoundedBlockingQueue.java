package ex.training.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {
    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    private Lock lock = new ReentrantLock();
    private Condition isNotFull = lock.newCondition();
    private Condition isNotEmpty = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        try {
            lock.lock();
            while (size == capacity) {
                isNotFull.await();
            }

            array[rear] = element;
            rear = (rear + 1 == capacity)
                    ? 0
                    : rear + 1;
            size++;
        } catch (Exception ignored) {

        } finally {
            isNotEmpty.signalAll();
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        try {
            lock.lock();
            while (size == 0) {
                isNotEmpty.await();
            }

            int num = array[front];
            front = (front + 1 == capacity)
                    ? 0
                    : front + 1;
            size--;

            return num;
        } catch (Exception ignored) {

        } finally {
            isNotFull.signalAll();
            lock.unlock();
        }
        return 0;
    }

    public int size() {
        return size;
    }
}
