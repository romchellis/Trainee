package training.map;

import java.util.Map;
import java.util.SortedMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashMap;
import java.util.TreeMap;

public class MapVsTreeMap {


    // USER  0 -> Million
    public static void main(String[] args) {
        treemap();  //-> -27768375,90974334,54848542,79859458
        hashMap();  //-> -16981791,27224333,80931250,120861041
    }

    public static void treemap() {
        SortedMap<Integer, Integer> userMap = IntStream.range(0, 1_000_000)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> i, (existing, replacement) -> existing, TreeMap::new));

        long start = System.nanoTime();
        userMap.subMap(0, 1_000_000).forEach((k, v) -> {
            User user = new User(k, String.valueOf(v));
        });
        long spent = System.nanoTime() - start;

        System.out.println(spent);
    }

    public static void hashMap() {
        Map<Integer, Integer> userMap = IntStream.range(0, 1_000_000)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> i, (existing, replacement) -> existing, HashMap::new));

        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            User user = new User(userMap.get(i), String.valueOf(userMap.get(i)));
        }
        long spent = System.nanoTime() - start;
        System.out.println(spent);
    }


    static class User {
        public int age;
        public String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
