package ex.training.bitmask;

import java.util.BitSet;

public class BitMask {
    public static void main(String[] args) {
        gen_set(4);
    }

    public int add(int mask, int x) {
        return search(mask, x)
                ? mask
                : mask + (1 << x);
    }

    private static boolean search(int mask, int x) {
        return (mask & x) == x;
    }

    static void set_print(int x) {
        int n = 0;
        while (x > 0) {
            if (x % 2 == 1) {
                System.out.print((char) ('a' + n));
            }
            x = x / 2;
            n++;
        }
    }

    static void gen_set(int N) {
        for (int x = 0; x <= (1 << N) - 1; x++) {
            set_print(x);
        }
    }
}
