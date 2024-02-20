//package ex.training.sortin;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Supplier;
//
//public class RadixSorter implements Sort {
//
//    public static void main(String[] args) {
//        System.out.println("Radix sort in Java");
//        int[] input = {181, 51, 11, 33, 11, 39, 60, 2, 27, 24, 12};
//        System.out.println("An Integer array before sorting");
//        System.out.println(Arrays.toString(input));
//        new RadixSorter().sort(input);
//        System.out.println("Sorting an int array using radix sort " +
//                "algorithm");
//        System.out.println(Arrays.toString(input));
//
//        var array = new int[10];
//
//
//
//    }
//
//    public void sort(int[] array) {
//        Consumer<int[]> sortFunction;
//        int n = array.length;
//        if (n < 10000) {
//            sortFunction = new InsertionSort()::sort;
//        } else if (n > 10000 && n < 100000) {
//            sortFunction = new QuickSort()::sort;
//        } else {
//            sortFunction = new MergeSort()::sort;
//        }
//        sortFunction.accept(array);
//    }
//
//    @Override
//    public void sort(int[] numbers) {
//        final int RADIX = 10;
//        List<Integer>[] bucket = new ArrayList[RADIX];
//        for (int i = 0; i < bucket.length; i++) {
//            bucket[i] = new ArrayList<>();
//        }
//        boolean maxLength = false;
//        int tmp = -1, placement = 1;
//        while (!maxLength) {
//            maxLength = true;
//            for (Integer i : numbers) {
//                tmp = i / placement;
//                bucket[tmp % RADIX].add(i);
//                if (maxLength && tmp > 0) {
//                    maxLength = false;
//                }
//            }
//            int a = 0;
//            for (int b = 0; b < RADIX; b++) {
//                for (Integer i : bucket[b]) {
//                    numbers[a++] = i;
//                }
//                bucket[b].clear();
//            }
//            placement *= RADIX;
//        }
//    }
//
//}
