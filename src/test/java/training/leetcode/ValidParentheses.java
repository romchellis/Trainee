package training.leetcode;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private final Map<Character, Character> map = Map.of(
            '}', '{',
            ')', '(',
            ']', '['
    );


    // abc {}
    public boolean isValid(String s) {



        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.map.containsKey(c)) {
                var topElement = stack.empty()
                        ? null
                        : stack.pop();
                if (this.map.get(c).equals(topElement)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
