package training.registry;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinServiceRegistry extends ServiceRegistry {

    private final AtomicInteger currPosition;

    public RoundRobinServiceRegistry(List<Service> services) {
        super(services);
        currPosition = new AtomicInteger(0);
    }

    @Override
    public Service get() {
        int index = currPosition.getAndIncrement();
        return services.get(index % services.size());
    }

}
