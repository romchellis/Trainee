package training.arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MountainArray {

    public static void main(String[] args) {
        try {
            try {
                throw new IOException("1");
            } finally {
                throw new IOException("2");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        var lastIncreasingIndex = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                lastIncreasingIndex = i;
                break;
            }
        }
        if (lastIncreasingIndex < 1) {
            return false;
        }
        for (int i = lastIncreasingIndex; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
