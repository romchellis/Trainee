package training.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    private static final PriorityQueue<Coin> coins = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(Coin::getCents)));

    enum Coin implements Comparable<Coin> {
        ONE(1), FIVE(5), TEN(10), DOLLAR(100);

        private final int cents;

        Coin(int cents) {
            this.cents = cents;
        }

        public int getCents() {
            return cents;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        //135
        coins.addAll(List.of(Coin.DOLLAR, Coin.TEN, Coin.TEN, Coin.FIVE, Coin.FIVE, Coin.FIVE));

        var copy = new PriorityQueue<>(coins);
        var change = new ArrayList<Coin>();
        int sum = 135;
        while (sum > 0) {
            var coin = copy.poll();
            var cents = coin.cents;
            if (sum >= cents) {
                change.add(coin);
                sum -= cents;
                coins.remove(coin);
            }
        }
        System.out.println("Change: " + change);
        System.out.println("Balance: " + coins);
    }

}
