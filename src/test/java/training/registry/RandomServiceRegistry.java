package training.registry;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RandomServiceRegistry extends ServiceRegistry {

    private final Supplier<Service> generatorFun;

    public RandomServiceRegistry(List<Service> services) {
        super(services);
        generatorFun = () -> {
            var index = ThreadLocalRandom.current().nextInt(0, super.services.size());
            return services.get(index);
        };
    }

    public RandomServiceRegistry(List<Service> services, Supplier<Service> fn) {
        super(services);
        generatorFun = Contracts.requireNonNull(fn);
    }


    @Override
    public Service get() {
        return generatorFun.get();
    }
}
