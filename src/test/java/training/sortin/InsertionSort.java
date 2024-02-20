package training.sortin;

public class InsertionSort implements Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 0, 1, 225, 3};
        float a = 27f;
        float v = new InsertionSort().sqrt3(a);
        System.out.println(v);
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public float sqrt3(float x) {
        float l = 1;
        float r = x;
        float delta = 0.0001f;
        while (Math.abs(l * l * l - x) > delta * delta) {
            float mid = (l + r) / 2;
            if (mid * mid * mid > x ) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

}
