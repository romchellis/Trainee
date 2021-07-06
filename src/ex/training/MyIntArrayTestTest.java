package ex.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyIntArrayTestTest {

    @Test
    public final void test() {
        MyIntArray a = new MyIntArray(4, 0);

        a.pushBack(5);
        assertEquals(a.get(a.getSize() - 1), 5);
        a.popBack();
        for (int i = 0; i < a.getSize(); i++) {
            assertEquals(a.get(i), 0);
        }
    }
}