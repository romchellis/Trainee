package training.map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayTraverse {

    private static final int SIZE = 10_000;

    public static void main(String[] args) {
//        int[] array = new int[SIZE];
//        for (int i = 0; i < array.length - 1; i++) {
//            array[i] = i;
//        }
        // iteration =   369958
        // system copy =  18083
//        long start = System.nanoTime();
//        System.arraycopy(array, 0, array, 1, array.length - 1);
//        long finish = System.nanoTime();
//        System.out.println(finish - start);

        var list = new LinkedList<Integer>(List.of(1, 2, 3, 290, 5, 6));
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            Integer val = iterator.next();
            if (val == 290) {
                iterator.remove();
            }
        }

        System.out.println(list);


//        int[][] twoDimensionalArray = new int[SIZE][SIZE];
//        Random random = new Random();
//        for (int i = 0; i < twoDimensionalArray.length; i++) {
//
//        }
//
//        // по строкам и по столбцам
//        byRows(twoDimensionalArray); // - 5464667
//        byColumns(twoDimensionalArray);// - 226585584
    }

    private static long iterative(int[] array, long start) {
        int first = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = first;
        long finish = System.nanoTime() - start;
        return finish;
    }

    private static void byRows(int[][] twoDimensionalArray) {
        long start = System.nanoTime();
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[0].length; j++) {
                int multiply = twoDimensionalArray[i][j];
            }
        }
        long finish = System.nanoTime() - start;
        System.out.println(finish);
    }
    // 1,2,3
    // 3,4,5

    private static void byColumns(int[][] twoDimensionalArray) {
        long start = System.nanoTime();
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray.length; j++) {
                int multiply = twoDimensionalArray[j][i];
            }
        }
        long finish = System.nanoTime() - start;
        System.out.println(finish);
    }
}
