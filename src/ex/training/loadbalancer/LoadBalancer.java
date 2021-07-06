package ex.training.loadbalancer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class LoadBalancer {

    protected final List<String> servers;

    protected LoadBalancer(List<String> servers) {
        List<String> copy = List.copyOf(servers);
        this.servers = copy;
    }

    public List<String> getServers() {
        return servers;
    }

    public abstract   String getIp();

}
