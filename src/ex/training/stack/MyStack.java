package ex.training.stack;

import java.util.Stack;

class MyStack {
    private Stack<Integer> data = new Stack();
    private Stack<Integer> min = new Stack();
    private Stack<Integer> max = new Stack();
    private int sum = 0;

    public void push(int v) {
        sum += v;
        if (!isEmpty()) {
            min.add(Math.min(v, min.peek()));
            max.add(Math.max(v, max.peek()));
        } else {
            min.add(v);
            max.add(v);
        }
        data.add(v);
    }

    public int pop() {
        int res = data.peek();
        data.pop();
        min.pop();
        max.pop();
        sum -= res;
        return res;
    }

    public boolean isEmpty() {
        return data.empty();
    }

    public int getMin() {
        return isEmpty() ? Integer.MAX_VALUE : min.peek();
    }

    public int getMax() {
        return isEmpty() ? Integer.MIN_VALUE : max.peek();
    }

    public int getSum() {
        return sum;
    }
}

class MyQueue {
    MyStack a = new MyStack();
    MyStack b = new MyStack();

    void push(int v) {
        a.push(v);
    }

    int pop() {
        if (!b.isEmpty()) {
            return b.pop();
        } else {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
            return pop();
        }
    }

    int min() {
        return Math.min(a.getMin(), b.getMin());
    }

    int max() {
        return Math.max(a.getMax(), b.getMax());
    }

    int sum() {
        return a.getSum() + b.getSum();
    }
}
