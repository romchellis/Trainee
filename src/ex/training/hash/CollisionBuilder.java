package ex.training.hash;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Random;

public class CollisionBuilder {
    private HashMap<Integer, String> map;
//
//    public static void main(String[] args) {
//        int p = 2;
//        int mod = 1000000000;
//        var result = getRes(p, mod);
//    }

//    private static Pair getRes(int p, int mod) {
//       String h = "helloworld";
//       String b = printHashValues(h);
//        return new Pair(h,  b);
//    }

    private static String printHashValues(String str) {
//        System.out.println("Original: " + str + " hash is " + str.hashCode());
//        byte[] array = new byte[n]; // length is bounded by 7
//        new Random().nextBytes(array);
//        String str = new String(array, StandardCharsets.UTF_8);
//        final char c[] = str.toCharArray();
//        int asciiMin = (int) '!';
//        int asciiMax = (int) '~';
//        for (int delta2 = -3; delta2 <= +3; delta2++) {
//            if (delta2 != 0) {
//                char orig2 = c[str.length() - 2];
//                int mod2 = orig2 + delta2;
//                boolean isInRange2 = asciiMin <= mod2 && mod2 <= asciiMax;
//                if (isInRange2) {
//                    char orig1 = c[str.length() - 1];
//                    int delta1 = delta2 * 31;
//                    int mod1 = orig1 - delta1;
//                    boolean isInRange1 = asciiMin <= mod1 && mod1 <= asciiMax;
//                    if (isInRange1) {
//                        char[] modc = str.toCharArray();
//                        modc[str.length() - 2] = (char) mod2;
//                        modc[str.length() - 1] = (char) mod1;
//                        String str2 = new String(modc);
//                        System.out.println(str2 + " hash is " + str2.hashCode());
//                        return str2;
//                    }
//                }
//            }
//        }
//        return new Pair<String,String>(str,str);
        return "";
    }

    static class Pair {
        public Pair(Integer a, Integer b) {
        }
    }
}
