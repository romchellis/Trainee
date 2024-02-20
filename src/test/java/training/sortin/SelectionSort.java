package training.sortin;

import java.util.Arrays;

public class SelectionSort implements Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 0, 1, 225, 3};
        new SelectionSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}
