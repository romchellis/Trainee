package training.list;

public class MyIntList {

    private int size;
    private Node tail;
    private Node head;

    public void pushBack(int val) {
        Node newNode = new Node(val);
        if (tail != null) {
            Node temp = tail;
            newNode.previous = temp;
            temp.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public void pushFront(int val) {
        Node newNode = new Node(val);
        if (head != null) {
            Node temp = head;
            newNode.next = head;
            temp.previous = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public int get(int idx) {
        if (idx > size) {
            return -1;
        }
        Node node = head;
        int i = 0;
        while (i < idx) {
            node = node.next;
            i++;
        }
        return node.data;
    }

    public void set(int idx, int val) {
        if (isEmpty()) {
            return;
        }
        Node node = head;
        for (int i = 0; head.next != null && i < idx; i++) {
            node = head.next;
        }
        node.data = val;
    }

    public void popBack() {
        if (isEmpty()) {
            return;
        }
        tail = tail.previous;
        if (tail != null)
            tail.next = null;
        else
            head = null;
    }

    public void popFront() {
        if (isEmpty()) {
            return;
        }
        head = head.next; // переносим последний элемент
        if (head != null)
            head.previous = null; // удаляем ссылку на удаленный элемент
        else
            tail = null;
    }

    public int back() {
        if (isEmpty()) {
            return -1;
        }
        return tail.data;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    static class Node {
        private int data;

        private Node next;
        private Node previous;

        public Node(int data) {
            this.data = data;
        }
    }
}
