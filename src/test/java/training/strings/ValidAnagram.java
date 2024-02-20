package training.strings;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int sHash = 1;
        int tHash = 1;
        for (int i = 0; i < s.length() && i < t.length(); i++){
            sHash = (sHash * ((s.charAt(i) + 1) & 255));
            tHash = (tHash * ((t.charAt(i) + 1) & 255));
        }
        return (s.length() == t.length()) && sHash == tHash;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(new ValidAnagram().isPalindrome(".,"));
    }

    public boolean isPalindrome(String s) {
        int rightIndex = s.length() - 1;
        int leftIndex = 0;
        while (leftIndex <= rightIndex) { // доп условие выхода??
            char left = s.charAt(leftIndex);  // comma
            char right = s.charAt(rightIndex); // space

            //буква                             не буква
            if (!isLetter(right)) {
                rightIndex--;
                continue;
            }

            if (!isLetter(left)) {
                leftIndex++;
                continue;
            }

            if (!equalsIgnoreCase(left, right)) {
                return false;
            }

            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public boolean isLetter(char a) {
        return Character.isLetterOrDigit(a);
    }

    public boolean equalsIgnoreCase(char a, char b) {
        return String.valueOf(a).equalsIgnoreCase(String.valueOf(b));
    }
}
