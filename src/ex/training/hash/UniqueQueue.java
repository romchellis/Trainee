package ex.training.hash;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class UniqueQueue {
    private Queue<Integer> queue = new ArrayDeque<>();
    private Set<Integer> uniques = new HashSet<>();

    void push(Integer val) {
        if (uniques.contains(val)) {
            return;
        }
        uniques.add(val);
        queue.add(val);
    }

    Integer pop() {
        if (queue.isEmpty()) {
            return 0;
        }
        Integer obj = queue.remove();
        if (obj != null) {
            uniques.remove(obj);
            return obj;
        } else return 0;
    }

}
