package training;// Code for Max Heap
import java.util.Collections;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) {
        // Construct an instance of Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 10; i++) {
            maxHeap.add(i);
        }

        for (int i = 0; i < 10; i++) {

            System.out.println(maxHeap.poll());
        }
    }
}