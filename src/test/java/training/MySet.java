package training;

import java.util.HashMap;
import java.util.Map;

public class MySet {
    private final Map<Integer, Object> map = new HashMap<Integer, Object>();
    private final Object mock = new Object();

    public void insert(Integer key) {
        map.put(key, mock);
    }

    public Boolean contains(int key) {
        return map.containsKey(key);
    }

    public void remove(Integer key) {
        map.remove(key);
    }
}
