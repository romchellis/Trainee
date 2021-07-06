package ex.training.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QueueTestTest {
    @Test
    public final void test() {
        Queue q = new Queue();
        q.worker(1);
        q.worker(2);
        q.boss(3);
        assertEquals(q.next(), 1);
        q.worker(4);
        q.boss(5);
        assertEquals(3, q.next());
        assertEquals(2, q.next());
        assertEquals(5, q.next());
        assertEquals(4, q.next());
    }
}