package training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        var stack = new Stack<ArrayList<Integer>>();
        getCompositions(4).forEach(stack::push);
        var string = "";
        while (!stack.isEmpty()) {
            ArrayList<Integer> integers = stack.pop();
            string += integers.stream().map(Object::toString).collect(Collectors.joining(" "));
            string += ",";
        }
        System.out.println(string);
    }

    private static ArrayList<ArrayList<Integer>> getCompositions(int n) {
        ArrayList<ArrayList<Integer>> listOfCompositions = new ArrayList<>();
        ArrayList<Integer> composition = new ArrayList<>();
        composition.add(n);
        while (composition != null) {
            listOfCompositions.add(composition);
            composition = getComposition(composition, n);
        }
        return listOfCompositions;
    }

    private static ArrayList<Integer> getComposition(ArrayList<Integer> previousComposition, int n) {
        ArrayList<Integer> currentComposition = new ArrayList<>(previousComposition);
        for (int i = currentComposition.size() - 1; i >= 0; i--) {
            if (currentComposition.get(i) != 1) {
                currentComposition.set(i, currentComposition.get(i) - 1);
                if (currentComposition.size() > i + 1) {
                    if (((currentComposition.size() - (i + 1)) > 1)) {
                        int sumOfOnes = 0;
                        for (int j = currentComposition.size() - 1; j >= i + 1; j--) {
                            sumOfOnes += currentComposition.get(j);
                            if (j != i + 1) currentComposition.remove(j);
                        }
                        currentComposition.set(i + 1, sumOfOnes + 1);
                    } else currentComposition.set(i + 1, currentComposition.get(i + 1) + 1);
                } else currentComposition.add(1);
                return currentComposition;
            }
        }
        return null;
    }


    static void gen_permutation(int[] perm, int k, boolean[] used) {
        int N = perm.length;
        if (k == N) {
            printGens(perm);
        } else {
            for (int x = N; x >= 1; x--) {
                if (!used[x]) {
                    perm[N - k - 1] = x;
                    used[x] = true;
                    gen_permutation(perm, k + 1, used);
                    used[x] = false;
                }
            }
        }
    }

    private static void printGens(int[] perm) {
        for (int j : perm) {
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println();
    }

    static void gen_placement(int[] place, int k, boolean[] used) {
        int K = place.length;
        int N = used.length;
        if (k == K) {
            printGens(place);
            return;
        }

        for (int x = 1; x <= N; x++) {
            if (used[x]) {
                continue;
            }
            place[k] = x;
            used[x] = true;
            gen_placement(place, k + 1, used);
            used[x] = false;
        }
    }


//    void bracket_sequence(char[] bs, int k, int balance, Stack<Character> s) {
//        if (k == N) {
//            for (int i = 0; i < N; i++) {
//                cout << bs[i];
//            }
//            cout << '\n';
//        } else {
//            if (balance > 0) { // можно поставить закрывающуюся
//                char top = s.top(); // достаём последнюю незакрытую скобку
//                s.pop();
//                // берём подходящую закрывающуюся скобку
//                char new_bracket = get_bracket(top); //
//                bs[k] = new_bracket;
//                bracket_sequence(bs, k + 1, balance - 1, s);
//                s.push(top); // возвращаем скобку на место
//            }
//            if (balance + 1 <= N - (k + 1)) { // можно поставить открывающуюся
//            }
//        }
//    }

}


