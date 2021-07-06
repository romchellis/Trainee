package ex.training.leetcode;

import java.util.Arrays;
import java.util.function.Function;

public class PlusOne {


    public int[] plusOne(int[] digits) {
        var arr = Arrays.stream(digits)
                .mapToObj(String::valueOf)
                .map(String::chars)
                .flatMapToInt(Function.identity())
                .mapToObj(it -> (char) it)
                .map(Character::getNumericValue)
                .mapToInt(it -> it)
                .toArray();

        arr[arr.length - 1] = arr[arr.length - 1] + 1;
        return new int[]{1};
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int max = 1;
        int length = 1;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (curr == prev) {
                length++;
            } else {
                length = 1;
            }
            if (length > max) {
                max = length;
            }
        }
        return max;
    }


}
