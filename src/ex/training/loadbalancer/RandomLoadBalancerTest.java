package ex.training.loadbalancer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomLoadBalancerTest {
    private RandomLoadBalancer randomLoadBalancer;
    private List<String> servers;

    @BeforeEach
    public void beforeAll() {
        servers = new ArrayList<>(Arrays.asList(
                "node-1",
                "node-2",
                "node-3",
                "node-4",
                "node-5"
        ));
        randomLoadBalancer = new RandomLoadBalancer(servers);
    }


    @Test
    public void getIpTest() {
        String ip = randomLoadBalancer.getIp();

        assertTrue(randomLoadBalancer.getServers().contains(ip));
    }

    @Test
    public void serversImmutabilityTest() {
        int sizeBeforeTryEdit = servers.size();
        servers.add("node-7");
        servers.add("node-8");

        assertThrows(UnsupportedOperationException.class, () ->
                randomLoadBalancer.getServers().add("node-7"));
        assertThrows(UnsupportedOperationException.class, ()
                -> randomLoadBalancer.getServers().add("node-8"));
        assertEquals(sizeBeforeTryEdit, randomLoadBalancer.getServers().size());
    }
}