package ex.training.loadbalancer;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class RoundRobinStreamingBalancer extends LoadBalancer {

    private final Iterator<String> iterator;

    public RoundRobinStreamingBalancer(final List<String> nodes) {
        super(nodes);
        var serverStream = Stream.generate(servers::stream).flatMap(Function.identity());
        iterator = serverStream.iterator();
    }

    @Override
    public synchronized String getIp() {
        return iterator.next();
    }

}


