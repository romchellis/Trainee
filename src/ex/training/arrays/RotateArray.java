package ex.training.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        var arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(arr, 3);
        Arrays.stream(arr).forEach(System.out::println);
    }
    

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (n != 1) {
            reverse(nums, 0, n - 1);
            reverse(nums, k, n - 1);
            reverse(nums, 0, k - 1);
        }
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
