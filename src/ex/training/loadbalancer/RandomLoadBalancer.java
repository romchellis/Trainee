package ex.training.loadbalancer;

import java.util.List;
import java.util.Random;

/**
 * Thread safe
 */
public class RandomLoadBalancer extends LoadBalancer {

    private final Random random;

    public RandomLoadBalancer(List<String> servers) {
        super(servers);
        random = new Random();
    }

    @Override
    public String getIp() {
        int index = random.nextInt(servers.size());
        return servers.get(index);
    }
}
