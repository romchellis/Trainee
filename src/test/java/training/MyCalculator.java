package training;

import java.time.LocalDate;
import java.util.Date;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public final class MyCalculator {


//    private final static Stack<Integer> numbers = new Stack<>();
//
//    static int calculate(String input) {
//        var date = new Date();
//        date.setYear(1999);
//        var localDate = LocalDate.now();
//
//        for (String something : input.split("\\s+")) {
//            try {
//                int i = Integer.parseInt(something);
//                numbers.push(i);
//            } catch (Exception e) {
//                BiFunction<Integer, Integer, Integer> operator = getOperator(something);
//                int value = numbers.pop();
//                int prev = numbers.pop();
//                int result = operator.apply(prev,value);
//                numbers.push(result);
//            }
//        }
//        return numbers.pop();
//    }
//
//    private final static BiFunction<Integer, Integer, Integer> getOperator(byte[] bytes) {
//        bytes.hashCode()
//        switch (something) {
//            case "+":
//                return Integer::sum;
//            case "-":
//                return (a, b) -> a - b;
//            case "/":
//                return (a, b) -> a / b;
//            case "*":
//                return (a, b) -> a * b;
//            default:
//                return null;
//        }
//    }
}
