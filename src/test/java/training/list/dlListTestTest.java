package training.list;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class dlListTestTest {
    @Test
    public final void test() {
        dlNode head = new dlNode(0, null, null);
        dlNode tail = head;
        int n = 5;
        for (int i = 1; i < n; i++) {
            dlNode node = new dlNode(i, null, tail);
            tail.next = node;
            tail = node;
        }

        dlList.replace(head, 1, 2, 3);

        dlNode ahead = new dlNode(0, null, null);
        dlNode atail = ahead;
        for (int i = 1; i < n; i++) {
            dlNode node = new dlNode(i, null, atail);
            atail.next = node;
            atail = node;
        }

        dlList.replace(ahead, 1, 2, 3);

        while (head != null) {
            assertTrue(head.val == ahead.val);
            head = head.next;
            ahead = ahead.next;
        }
    }

    @Test
    public final void test2() {
        dlNode head = new dlNode(0, null, null);
        dlNode tail = head;
        int n = 3;
        for (int i = 1; i < n; i++) {
            dlNode node = new dlNode(i, null, tail);
            tail.next = node;
            tail = node;
        }

        dlList.expand(head);

        dlNode ahead = new dlNode(0, null, null);
        dlNode atail = ahead;
        for (int i = 1; i < n; i++) {
            dlNode node = new dlNode(i, null, atail);
            atail.next = node;
            atail = node;
        }

        dlList.expand(ahead);

        while (head != null) {
            assertTrue(head.val == ahead.val);
            head = head.next;
            ahead = ahead.next;
        }
    }
}