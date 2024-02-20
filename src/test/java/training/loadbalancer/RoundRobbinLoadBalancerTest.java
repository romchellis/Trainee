package training.loadbalancer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoundRobbinLoadBalancerTest {

    private LoadBalancer balancer;

    @BeforeEach
    public void setUp() {
        var servers = new ArrayList<>(Arrays.asList(
                "node-0",
                "node-1",
                "node-2",
                "node-3",
                "node-4"
        ));
        balancer = new RoundRobbinLoadBalancer(servers);
    }

    @Test
    public void getIpTest() {
        String ip = balancer.getIp();
        String ip2 = balancer.getIp();

        assertEquals("node-0", ip);
        assertEquals("node-1", ip2);
    }

    @Test
    public void getCycleTest() {
        var serverCount = balancer.getServers().size();
        for (int i = 0; i < 10; i++) {
            var ip = balancer.getIp();
            var nodeNum = i % serverCount;
            assertEquals("node-" + nodeNum, ip);
        }
    }

}