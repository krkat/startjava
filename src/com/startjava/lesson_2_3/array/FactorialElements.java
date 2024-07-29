package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class Factorial {
    public static void main(String[] args) {
        Integer[] ints1 = {8, 0, 9};
        Integer[] ints2 = {-3, 1, 7, 13};
        Integer[] ints3 = {-22, -0};
        output(countFactorial());
        output(countFactorial(null));
        output(countFactorial(ints1));
        output(countFactorial(ints2));
        output(countFactorial(ints3));
    }

    private static Integer[] countFactorial(Integer... args) {
        if (args == null || args.length == 0) {
            return args;
        }
        int length = args.length;
        Integer[] resultArgs = new Integer[length];
        int factorial;
        for (int i = 0; i < length; i++) {
            if (args[i] <= 0) {
                resultArgs[i] = null;
                continue;
            }
            factorial = 1;
            for (int j = 1; j <= args[i]; j++) {
                factorial *= j;
            }
            resultArgs[i] = factorial;
        }
        return resultArgs;
    }

    private static void output(Integer... args) {
        if (args == null) {
            System.out.println("null");
            return;
        }
        if (args.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.println(Arrays.toString(args));
    }
}