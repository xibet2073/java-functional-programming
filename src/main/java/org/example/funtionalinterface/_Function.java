package org.example.funtionalinterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(0);
        System.out.println(increment);

        Integer incrementByOneLambda = incrementByOneFunction.apply(1);
        System.out.println(incrementByOneLambda);

        int multiply = multiplyBy10Function.apply(incrementByOneLambda);
        System.out.println(multiply);

        Function<Integer, Integer> addByOneAndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        int incrementAndMultiply = addByOneAndThenMultiplyBy10.apply(4);
        System.out.println(incrementAndMultiply);
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;
    static int incrementByOne(int number) {
        return number + 1;
    }
}
