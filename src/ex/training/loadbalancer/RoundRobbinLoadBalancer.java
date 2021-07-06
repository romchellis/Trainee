package ex.training.loadbalancer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobbinLoadBalancer extends LoadBalancer {

    private final AtomicInteger counter = new AtomicInteger(-1);

    public RoundRobbinLoadBalancer(List<String> servers) {
        super(servers);
    }

    @Override
    public String getIp() {
        var index = counter.incrementAndGet();
        if (index > servers.size() - 1) {
            synchronized (servers) {
                if (index > servers.size() - 1) {
                    counter.set(0);
                    index = 0;
                }
            }
        }
        return servers.get(index);
    }

}
