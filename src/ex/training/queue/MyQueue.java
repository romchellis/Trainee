package ex.training.queue;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();

    void push(int v) {
        a.push(v);
    }

    int pop() {
        if (!b.isEmpty()) {
            return b.pop();
        }

        int size = a.size() ;
        for (int i = 0; i < size; i++) {
            int val = a.pop();
            b.push(val);
        }
        return b.pop();
    }
}
