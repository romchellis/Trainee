package ex.training.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyIntListTestTest {

    @Test
    public final void test() {
        MyIntList list = new MyIntList();
        list.pushFront(2);
        list.pushFront(1);
        list.pushBack(3);
        for (int i = 0; i < 3; i++) {
            assertEquals(i + 1, list.get(i));
        }
        list.popFront();
        list.popBack();
        assertTrue(list.back() == list.front());
        assertTrue(list.back() == 2);
    }

    @Test
    public final void test2() {
        MyIntList list = new MyIntList();
        list.pushBack(1);
        list.pushFront(2);
        list.pushBack(0);
        list.pushFront(3);
        for (int i = 0; i < 4; i++) {
            System.out.println(list.get(i));
//            assertEquals(i , list.get(i));
        }
    }

}