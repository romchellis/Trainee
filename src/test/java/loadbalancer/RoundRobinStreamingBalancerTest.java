package loadbalancer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ex.training.loadbalancer.LoadBalancer;
import ex.training.loadbalancer.RoundRobinStreamingBalancer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoundRobinStreamingBalancerTest {

    private LoadBalancer balancer;
    private List<String> nodes;

    @BeforeEach
    void setUp() {
        nodes = List.of("1", "2", "3");
        balancer = new RoundRobinStreamingBalancer(nodes);
    }

    @Test
    public void getIpTest() {
        var output = new ConcurrentLinkedQueue<String>();
        var expectedOutput = new ArrayList<String>();
        expectedOutput.addAll(nodes);
        expectedOutput.addAll(nodes);
        expectedOutput.addAll(nodes);

        IntStream.range(0, 9)
                .boxed()
                .parallel()
                .forEach(it -> output.add(balancer.getIp()));
        List<String> result = new ArrayList<>(output);

        assertEquals(expectedOutput, result);
    }
}