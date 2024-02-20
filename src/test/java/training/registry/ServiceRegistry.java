package training.registry;


import java.util.List;

//Develop a Service Registry using TDD. It can only have 10 records, and no duplicates.
//Then implement a get() method with 2 strategies: random and Round Robin.
public abstract class ServiceRegistry {
    private static final int maxSize = 10;

    protected final List<Service> services;

    public ServiceRegistry(List<Service> services) {
        this(services, maxSize);
    }

    protected ServiceRegistry(List<Service> services, int size) {
        this.services = List.copyOf(Contracts.requireLessThanSize(services, size));
    }


    public abstract Service get();
}
