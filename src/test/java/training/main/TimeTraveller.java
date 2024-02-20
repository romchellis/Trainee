package ex.training.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class TimeTraveller {


    public static void main(String[] args) {
        int pos = 3;
        Integer[] queue1 = {2, 2, 2, 2, 2};
        LinkedList<Person> queue = Arrays.stream(queue1)
                .map(Person::new)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(iterCount(queue, pos));
    }

    static class Person {
        private int tickets;

        Person(int tickets) {
            this.tickets = tickets;
        }
    }

    //1,2,3
    //2,3
    //3,1
    //2
    //1
    //0
    private static int iterCount(LinkedList<Person> queue, int pos) {
        int count = 0;
        while (!queue.isEmpty()) {
            var first = queue.removeFirst(); //poll him
            if (--first.tickets > 0) { // if decreased tickets > 0 add to tail
                queue.addLast(first);
            }
            if (pos == 0) {
                pos = queue.size() - 1;
            } else {
                return count;
            }
            count++;
        }
        return count;
    }


    private static void shift(LinkedList<Integer> list) {
        if (list.size() > 1) {
            Integer first = list.pollFirst();
            Integer last = list.pollLast();
            list.addLast(first);
            list.addFirst(last);
        }

    }

    private static void shift(int[] arr, int size) {
        // 123 23
        int first = arr[0];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = first;
    }
}
