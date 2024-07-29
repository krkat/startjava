package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class FactorialElements {
    public static void main(String[] args) {
        outputFactorial();
        outputFactorial(null);
        outputFactorial(8, 0, 9);
        outputFactorial(-3, 1, 7, 13);
        outputFactorial(-22, -0);
    }

    private static void outputFactorial(Integer... args) {
        System.out.print("\nИсходный иассив: ");
        output(args);
        System.out.println("Вычисление факториалов элементов: ");
        output(count(args));
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

    private static Integer[] count(Integer... args) {
        if (args == null || args.length == 0) {
            System.out.println("Невозможно вычислить факториал элементов, т.к. массив null или нулевой длины");
            return args;
        }
        int length = args.length;
        Integer[] result = new Integer[length];
        for (int i = 0; i < length; i++) {
            if (args[i] < 0) {
                System.out.println("Ошибка: факториал " + args[i] + "! не определен");
                result[i] = null;
                continue;
            }
            System.out.print(args[i] + "! = ");
            result[i] = 1;
            if (args[i] != 0 && args[i] != 1) {
                for (int j = 1; j <= args[i]; j++) {
                    System.out.print(j);
                    result[i] *= j;
                    System.out.print(j != args[i] ? " * " : " = ");
                }
            }
            System.out.println(result[i]);
        }
        return result;
    }
}