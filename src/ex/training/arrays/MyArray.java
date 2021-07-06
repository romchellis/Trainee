package ex.training.arrays;

import java.util.Arrays;

public class MyArray {
    private final Object[] array;

    public MyArray(Object[] array) {
        this.array = array;
    }

    public void print() {
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void main(String[] args) {

    }
}
