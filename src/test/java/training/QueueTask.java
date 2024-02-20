package training;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

public class QueueTask {

    interface QueueSolver {

        int calculateSteps(int[] checks, int targetPerson);
    }

    public static void main(String[] args) {
//        QueueSolver solution = new LinkedListSolver();
//
//        int[] checks1 = {2, 5, 3, 4};
//        int targetPerson1 = 2;
//        System.out.println(solution.calculateSteps(checks1, targetPerson1)); //  10
//
//        int[] checks2 = {1, 1, 1, 1};
//        int targetPerson2 = 3;
//        System.out.println(solution.calculateSteps(checks2, targetPerson2)); //  4
//
//        int[] checks3 = {};
//        int targetPerson3 = 0;
//        System.out.println(solution.calculateSteps(checks3, targetPerson3)); //  0
//
//        int[] checks4 = {5, 2, 3, 4};
//        int targetPerson4 = 0;
//        System.out.println(solution.calculateSteps(checks4, targetPerson4)); //  14
//
//        int[] checks5 = {2, 3, 4, 5};
//        int targetPerson5 = 3;
//        System.out.println(solution.calculateSteps(checks5, targetPerson5)); //  14
//
//        int[] checks6 = {3};
//        int targetPerson6 = 0;
//        System.out.println(solution.calculateSteps(checks6, targetPerson6)); //  3
//
//        int[] checks7 = {2, 1, 3};
//        int targetPerson7 = 1;
//        System.out.println(solution.calculateSteps(checks7, targetPerson7)); //  2

        int n = 1000000;
        int[] checks = new int[n];
        for (int i = 0; i < n; i++) {
            checks[i] = 10; // Все клиенты имеют по 10 чеков
        }

        QueueSolver solution = new LinkedListSolver();

        long startTime = System.currentTimeMillis();
        System.out.println(solution.calculateSteps(checks, 500000));
        long endTime = System.currentTimeMillis();
        System.out.println("Время с использованием ArrayDeque: " + (endTime - startTime) + " мс");

        solution = new ArraySolver();
        startTime = System.currentTimeMillis();
        System.out.println(solution.calculateSteps(checks, 500000));
        endTime = System.currentTimeMillis();
        System.out.println("Время с использованием LinkedList: " + (endTime - startTime) + " мс");

        solution = new MutableIntSolver();
        startTime = System.currentTimeMillis();
        System.out.println(solution.calculateSteps(checks, 500000));
        endTime = System.currentTimeMillis();
        System.out.println("Время с использованием MutableInt: " + (endTime - startTime) + " мс");

        solution = new MathSolver();
        startTime = System.currentTimeMillis();
        System.out.println(solution.calculateSteps(checks, 500000));
        endTime = System.currentTimeMillis();
        System.out.println("Время с использованием MathSolver: " + (endTime - startTime) + " мс");
    }


    static class LinkedListSolver implements QueueSolver {
        @Override
        public int calculateSteps(int[] checks, int targetPerson) {
            final var list = new ArrayDeque<Integer>() {{
                for (int check : checks) add(check);
            }};
            int count = 0;
            while (!list.isEmpty()) {
                int remaining = list.pollFirst() - 1;
                count++;
                targetPerson--;
                if (remaining > 0) {
                    list.addLast(remaining);
                    if (targetPerson == -1) targetPerson = list.size() - 1;
                } else { // no checks remaining
                    if (targetPerson == -1) return count;
                }
            }
            return count;
        }
    }

    static class ArraySolver implements QueueSolver {
        @Override
        public int calculateSteps(int[] checks, int targetPerson) {
            final var list = new LinkedList<Integer>() {{
                for (int check : checks) add(check);
            }};
            int count = 0;
            while (!list.isEmpty()) {
                int remaining = list.pollFirst() - 1;
                count++;
                targetPerson--;
                if (remaining > 0) {
                    list.addLast(remaining);
                    if (targetPerson == -1) targetPerson = list.size() - 1;
                } else { // no checks remaining
                    if (targetPerson == -1) return count;
                }
            }
            return count;
        }
    }

    static class MutableIntSolver implements QueueSolver {

        @Override
        public int calculateSteps(int[] checks, int targetPerson) {
            ArrayDeque<Int> queue = new ArrayDeque<>();
            for (int i = 0; i < targetPerson; i++) {
                Int anInt = new Int(checks[i]);
                queue.add(anInt);
            }
            Int target = new Int(checks[targetPerson]);
            queue.add(target);
            for (int i = targetPerson + 1; i < checks.length; i++) {
                Int anInt = new Int(checks[i]);
                queue.add(anInt);
            }

            int count = 0;
            while (target.val > 0) {
                Int remaining = queue.pollFirst();
                remaining.val--;
                count++;
                if (remaining.val > 0) {
                    queue.addLast(remaining);
                }
            }
            return count;
        }
//есть ли вариант решения задачи без симуляции процесса?

    }

    static class MathSolver implements QueueSolver {
        @Override
        public int calculateSteps(int[] checks, int targetPerson) {
            int totalSteps = 0;
            for (int check : checks) {
                totalSteps += check;
            }

            int stepsBeforeTarget = Arrays.stream(checks, 0, targetPerson).sum();

            int stepsToTarget = stepsBeforeTarget + checks[targetPerson];

            return Math.min(stepsBeforeTarget, totalSteps - stepsBeforeTarget) + stepsToTarget;
        }

    }

    static class Int {
        int val;

        public Int(int val) {
            this.val = val;
        }
    }


}
