//import java.lang.reflect.Array;
//import java.util.*;
//
//enum Coin {
//    ONE(1), TWO(2), FIVE(5); // Пример номиналов монет
//
//    private final int value;
//
//    Coin(int value) {
//        this.value = value;
//    }
//
//    public int getValue() {
//        return value;
//    }
//}
//
//public class CoinChangeWithQuantity {
//
//    //Pre-order root->left->left
//    void preOrder(TreeNode root, List<Integer> list) {
//        if (root == null) return;
//
//        list.add(root.val);
//        preOrder(root.left, list);
//        preOrder(root.right, list);
//    }
//
//    //In-order left->root->subtree.
//    void inorder(TreeNode node, List<Integer> list) {
//        if (node == null) return;
//
//        inorder(node.left, list);
//        list.add(node.val);
//        inorder(node.right, list);
//    }
//
//    //Post-order left->right->root.
//    void postOrder(TreeNode node, List<Integer> list) {
//        if (node == null) return;
//
//        postOrder(node.left, list);
//        postOrder(node.right, list);
//        list.add(node.val);
//    }
//
//
//    public static List<Coin> coinChange(Map<Coin, Integer> coins, int amount) {
//        List<Coin> result = new ArrayList<>();
//        Map<Integer, List<List<Coin>>> dp = new HashMap<>();
//
//        dp.put(0, new ArrayList<>());
//        dp.get(0).add(new ArrayList<>());
//
//        int[] a = new int[1];
//
//        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
//            Coin coin = entry.getKey();
//            int coinQuantity = entry.getValue();
//
//            for (int j = amount; j >= coinValue; j--) {
//                for (int k = 1; k <= coinQuantity && k * coinValue <= j; k++) {
//                    int remainingAmount = j - k * coinValue;
//
//                    if (dp.containsKey(remainingAmount)) {
//                        List<List<Coin>> combinations = dp.get(remainingAmount);
//                        for (List<Coin> combination : combinations) {
//                            List<Coin> currentCombination = new ArrayList<>(combination);
//                            for (int count = 0; count < k; count++) {
//                                currentCombination.add(coin);
//                            }
//                            dp.computeIfAbsent(j, key -> new ArrayList<>()).add(currentCombination);
//                        }
//                    }
//                }
//            }
//        }
//
//        if (dp.containsKey(amount)) {
//            List<List<Coin>> combinations = dp.get(amount);
//            if (!combinations.isEmpty()) {
//                result = combinations.get(0);
//            }
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Map<Coin, Integer> coins = new HashMap<>();
//        coins.put(Coin.ONE, 2); // 5 монет номиналом 1
//        coins.put(Coin.TWO, 2); // 3 монеты номиналом 2
//        coins.put(Coin.FIVE, 2); // 2 монеты номиналом 5
//
//        int amount = 10; // Сумма, которую нужно собрать
//
//        List<Coin> result = coinChange(coins, amount);
//        System.out.println("Монеты для суммы " + amount + ": " + result);
//    }
//}
