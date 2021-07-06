package ex.training.queue;

import java.util.LinkedList;

public class MyDeque {
    LinkedList<Integer> data = new LinkedList<>();

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void pushBack(int val) {
        data.addLast(val);
    }

    public Integer popBack() {
        return data.pollLast();
    }

    public void pushFront(int val) {
        data.addFirst(val);
    }

    public Integer popFront() {
        return data.pollFirst();
    }
}
