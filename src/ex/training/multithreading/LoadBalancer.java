package ex.training.multithreading;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class LoadBalancer {
    public static void main(String[] args) {
        var nodes = Stream.of("Chungton", "Everson", "Gabbelson")
                .map(Node::new)
                .collect(Collectors.toList());

        var b = new LoadBalancer(nodes);
        LongStream.range(0, 15).boxed()
                .parallel()
                .forEach(it -> b.processRequest(it.toString()));
    }


    private int current;
    private final List<Node> nodes;
    private final Lock lock = new ReentrantLock();

    public LoadBalancer(List<Node> nodes) {
        this.nodes = nodes;
    }


    public void processRequest(String req) {
        lock.lock();
        try {
            if (current == nodes.size() - 1) {
                current = 0;
            } else {
                current++;
            }
            nodes.get(current).process(req);
        } finally {
            lock.unlock();
        }
    }


    static class Node {
        private final String name;

        public Node(String name) {
            this.name = name;
        }

        public void process(String req) {
            System.out.println("Node: " + name + " proccessing request");
        }
    }
}
