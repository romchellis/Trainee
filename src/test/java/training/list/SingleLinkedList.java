package training.list;

public class SingleLinkedList {
    void push_front(int x) {
        head = new SlNode(this.head, x);
    }

    void pop_front() {
        SlNode p = head;
        if (p != null) {
            head = p.next;
        }
    }

    void push_back(int x) {
        SlNode p = head, prev = null;
        while (p != null) {
            prev = p;
            p = p.next;
        }
        p = new SlNode(null, x);
        if (prev != null)
            prev.next = p;
        else
            head = p;
    }

    void pop_back() {
        SlNode p = head, prev = null;
        while (p != null && p.next != null) {
            prev = p;
            p = p.next;
        }
        if (p != null) {
            if (prev != null)
                prev.next = null;
            else
                head = null;
        }
    }


    void push_after(int pos, int x) {
        int i = 0;
        SlNode p = head;
        while (i < pos && p != null) {
            ++i;
            p = p.next;
        }
        if (i == pos && p != null) {
            p.next = new SlNode(p.next, x);
        }
    }

    void pop_after(int pos) {
        int i = 0;
        SlNode p = head;
        while (i < pos && p != null) {
            ++i;
            p = p.next;
        }
        if (i == pos && p != null && p.next != null) {
            p.next = p.next.next;
        }
    }

    SlNode head = null;

    public static class SlNode {
        SlNode(SlNode next, int val) {
            this.next = next;
            this.item = val;
        }

        SlNode next;
        int item;
    }

    static SlNode reverse(SlNode sll) {
        SlNode p = sll;
        SlNode prev = null;
        SlNode next;
        while (p != null) {
            next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }

    static boolean has_cycle(SlNode sll) {
        SlNode fast, slow;
        fast = sll;
        slow = sll;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    SlNode kth_element(SlNode head, int k) {
        SlNode tail = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }
        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }
        return tail;
    }

    void insert(SlNode head, int k, int val) {
        for (int i = 0; i < k; i++) {
            head = head.next;
            if (head == null) {
                return;
            }
        }
        head.next = new SlNode(head.next, val);
    }

    SlNode merge_sorted(SlNode p, SlNode q) {
        SlNode helper = new SlNode(null, 0);
        SlNode t = helper;
        while (true) {
            if (p == null) {
                t.next = q;
                break;
            } else if (q == null) {
                t.next = p;
                break;
            }
            if (p.item < q.item) {
                t.next = p;
                t = p;
                p = p.next;
            } else {
                t.next = q;
                t = q;
                q = q.next;
            }
        }
        t = helper.next;
        return t;
    }

}

