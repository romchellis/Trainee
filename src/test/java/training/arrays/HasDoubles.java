package training.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class HasDoubles {
    public static void main(String[] args) {
        int[][] tests = new int[][]{
                new int[]{10, 2, 5, 3},
                new int[]{7, 1, 14, 11},
                new int[]{3, 1, 7, 11}
        };


        var collect = Arrays.stream(tests)
                .map(HasDoubles::checkIfExist)
                .collect(Collectors.toList());
        var ok = List.of(true, true, false);

        System.out.println(collect.equals(ok));
    }

    public static boolean checkIfExist(int[] arr) {
        var table = new HashSet<Integer>();
        for (int a : arr) {
            var contains = false;
            if (a % 2 == 0) {
                contains = table.contains(a * 2) || table.contains(a / 2);
            } else {
                contains = table.contains(a * 2);
            }

            if (contains) {
                return true;
            }
            table.add(a);
        }
        return false;
    }


}
