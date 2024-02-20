package training.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Queue {
    private LinkedList<Integer> peoples = new LinkedList<>();

    public void worker(int i) {
        peoples.addLast(i);
    }

    public void boss(int i) {
        int size = peoples.size();
        if (size == 0) {
            peoples.add(i);
            return;
        }
        int bossIndex = size % 2 == 0
                ? size / 2
                : size / 2 + 1;
        peoples.add(bossIndex, i);
    }

    public int next() {
        if (peoples.isEmpty()) {
            return -1;
        }
        return peoples.removeFirst();
    }
}
