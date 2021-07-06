package ex.training;

public class GreatCommonDivisor {
    int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    int findGCD(int arr[], int n) {
        int result = 0;
        for (int element : arr) {
            result = gcd(result, element);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GreatCommonDivisor greatCommonDivisor = new GreatCommonDivisor();
        int pow = greatCommonDivisor.binpow(2, 2);
        System.out.println(pow);
    }

    int binpow (int a, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return binpow (a, n-1) * a;
        else {
            int b = binpow (a, n/2);
            return b * b;
        }
    }
}
