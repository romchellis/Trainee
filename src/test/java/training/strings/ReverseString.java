package training.strings;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class ReverseString {

    public static void main(String[] args) {
        var strings = List.of("Privet", "Mama", "Adam");
        var r = new ReverseString();
//        System.out.println(
//                strings.stream().map(it -> r.reverseString(it.toCharArray())).collect(toList())
//        );


        var numbers = List.of(120, -123, 123, 0);
        System.out.println(
                numbers.stream().map(r::reverse).collect(toList())
        );
//        Input: x = 123
//        Output: 321
//        Example 2:
//
//        Input: x = -123
//        Output: -321
//        Example 3:
//
//        Input: x = 120
//        Output: 21
//        Example 4:
//
//        Input: x = 0
//        Output: 0
    }

    public char[] reverseString(char[] s) {
        var left = s.length - 1;
        for (int rigth = 0; rigth < (s.length / 2); rigth++) {
            var temp = s[rigth];
            s[rigth] = s[left];
            s[left] = temp;
            left--;
        }
        return s;
    }

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }
}
