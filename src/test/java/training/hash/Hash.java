package training.hash;

public class Hash {
    public static void main(String[] args) {
        int sfalgoHash = h("sfalgo", 2, 1000000000);
        int duplic = h("sfalgo", 2, 1000000000);
        System.out.println(sfalgoHash);
        System.out.println(duplic);
    }

    static int h(String s, int p, int mod) { //главная функция для вычисления полиномиального хеша
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += Math.pow(p, i) * (s.charAt(i) - 'a');
            res %= mod; // вычисляем по формуле
        }
        return res;
    }


}
