package training.loadbalancer;

import java.util.List;

public abstract class LoadBalancer {

    protected final List<String> servers;

    protected LoadBalancer(List<String> servers) {
        this.servers = List.copyOf(servers);
    }

    public List<String> getServers() {
        return servers;
    }

    public abstract   String getIp();

}
