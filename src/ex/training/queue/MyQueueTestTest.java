package ex.training.queue;

import java.time.temporal.ChronoField;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyQueueTestTest {
    @Test
    public final void test() {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        var intance = Calendar.getInstance();
        intance.set(1999, 05, 15);
        System.out.println(intance.toInstant().get(ChronoField.YEAR));
        intance.set(2021, 04, 4);
        System.out.println(intance.toInstant().get(ChronoField.YEAR));
        assertTrue(q.pop() == 1);
        assertTrue(q.pop() == 2);
        assertTrue(q.pop() == 3);
    }
}