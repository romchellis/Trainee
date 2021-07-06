package ex.training.cache;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class LRUCacheTestTest {
    @Test
    public final void testFindMaximumElement1() {

        Random rand = new Random();

        int size = 100000;
        int pageSize = size * 2;
        LRUCache cache = new LRUCache(pageSize, size);

        int q = 100000;
        for (int i = 0; i < q; i++) {
            int get = rand.nextInt(pageSize);
            cache.get(get);

            int page = rand.nextInt(pageSize);
        }
    }
}