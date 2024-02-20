package training.sortin;

import java.util.Arrays;

public class BubbleSort implements Sort{
    public static void main(String[] args) {
        int[] arr = new int[]{6, 0, 1, 225, 3};
        new SelectionSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        while (true) {
            boolean was_swap = false;

            for (int i = 0; i < n - 1; ++i) {
                if (arr[i + 1] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    was_swap = true;
                }
            }

            if (!was_swap) {
                break;
            }
        }
    }
}
