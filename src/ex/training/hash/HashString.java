package ex.training.hash;

import java.util.HashSet;
import java.util.Set;

public class HashString {
    private String string;

    public String get() {
        return string;
    }

    public void set(String string) {
        this.string = string;
    }

    public HashString(String string) {
        this.string = string;
    }

    public HashString() {
    }


    public boolean isSubString(HashString another) {
        int j = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == another.get().charAt(j)) {
                j++;
                if (j == another.get().length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEquals(HashString another) {
        return another.get().intern() == string.intern();
    }

    public int pNumbers() {
        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j <= string.length(); j++) {
                HashString substring = new HashString(string);
                if (isP(i, j)) {
                    palindromes.add(substring.get().substring(i, j));
                }
            }
        }
        return palindromes.size();
    }

    public boolean isMore(HashString other) {
        return false;
    }

    public boolean isP(int low, int high) {
        Set<String> result = new HashSet<>();
        while (low >= 0 && high < string.length() && string.charAt(low) == string.charAt(high)) {
            result.add(string.substring(low, high + 1));
            low--;
            high++;
        }
        return !result.isEmpty();
    }
}
