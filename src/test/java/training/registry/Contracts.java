package training.registry;

import java.util.Collection;

public class Contracts {
    public static <T> Collection<T> requireLessThanSize(Collection<T> coll, int size) {
        requireNonNull(coll);
        if (coll.size() > size) {
            String msg = String.format("Collection has size %s , where %s is max", coll.size(), size);
            throw new IllegalArgumentException(msg);
        }
        return coll;
    }

    public static <T> T requireNonNull(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null!");
        }
        return obj;
    }
}
