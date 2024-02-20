package training.leetcode;

import java.util.List;

public class MissingNumber {
    public static void main(String[] args) {
        var mn = new MissingNumber();
        var test = List.of(
                new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1},
                new int[]{0, 1},
                new int[]{3, 0, 1}
        );

        test.forEach(it -> {
            var result = mn.missingNumber(it);
            System.out.println(result);
        });
    }

    public int missingNumber(int[] nums) {
        var n = nums.length;
        var sum = 0;
        var cumulative = n;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            sum += number;
            cumulative += i;
        }
        return cumulative - sum;
    }
}
