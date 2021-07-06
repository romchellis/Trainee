package ex.training.list;

public class dlList {
    private dlNode tail, head;

    public void pushBack(int val) {
        if (isEmpty()) {
            head = new dlNode(val);
            tail = head;
            return;
        }
        dlNode newNode = new dlNode(val);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void pushFront(int val) {
        if (isEmpty()) {
            head = new dlNode(val);
            tail = head;
            return;
        }
        dlNode newNode = new dlNode(val);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void popBack() {
        if (isEmpty()) {
            return;
        }
        tail = tail.prev;
        if (tail != null)
            tail.next = null;
    }

    public void popFront() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head != null)
            head.prev = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int front() {
        if (head != null) {
            return head.val;
        } else {
            return -1;
        }
    }

    void pushAfter(int pos, int x) {
        int i = 0;
        dlNode p = head;
        while (i < pos && p != null) {
            ++i;
            p = p.next;
        }
        if (i == pos && p != null) {
            p.next = new dlNode(x, p.next, p);
            if (p.next.next != null) {
                p.next.prev = p.next;
            }
        }
    }

    void popAfter(int pos) {
        int i = 0;
        dlNode p = head;
        while (i < pos && p != null) {
            ++i;
            p = p.next;
        }
        if (i == pos && p != null && p.next != null) {
            p.next = p.next.next;
            if (p.next.next != null) {
                p.next.next.prev = p;
            }
        }
    }


    static void replace(dlNode head, int l, int r, int idx) {
        dlNode start = head;
        start = getDlNode(idx, start);
        if (start == null) {
            return;
        }

        dlNode left = head;
        left = getDlNode(l, left);
        dlNode right = head;
        right = getDlNode(r - 1, right);
        if (right == null) {
            return;
        }
        if (left.prev != null) {
            left.prev.next = right.next;
        }
        if (right.next != null) {
            right.next.prev = left.prev;
        }
        dlNode next = start.next;
        if (next != null) {
            next.prev = right;
        }
        start.next = left;
        left.prev = start;
        right.next = next;
    }

    private static dlNode getDlNode(int l, dlNode left) {
        for (int i = 0; i < l && left != null; i++) {
            left = left.next;
        }
        return left;
    }

    static void expand(dlNode start) {
        int index = 0;
        while (start != null) {

            start = start.next;
        }
    }

    static void add(dlNode node, int val) {
        dlNode new_node = new dlNode(val, node.next, node);
        if (node.next != null) {
            node.next.prev = new_node;
            node.next = new_node;
        }
    }

}

class dlNode {
    dlNode(int val) {
        this.val = val;
    }

    dlNode(int val, dlNode next, dlNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    int val;
    dlNode next = null;
    dlNode prev = null;

}