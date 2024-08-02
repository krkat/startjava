package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class FactorialElements {
    public static void main(String[] args) {
        calcFactorial();
        Integer[] a = null;
        calcFactorial(a);
        calcFactorial(8, 0, 9);
        calcFactorial(-3, 1, 7, 13);
        calcFactorial(-22, -0);
    }

    private static void calcFactorial(Integer... ints) {
        System.out.print("\nИсходный массив: ");
        output(ints);
        calc(ints);
    }

    private static void output(Integer... ints) {
        if (ints == null) {
            System.out.println("Ошибка! Массив null");
            return;
        }
        if (ints.length == 0) {
            System.out.println("Ошибка! Массив нулевой длины");
            return;
        }
        System.out.println(Arrays.toString(ints));
    }

    private static Integer[] calc(Integer... ints) {
        if (ints == null || ints.length == 0) {
            return null;
        }
        System.out.println("Вычисление факториалов элементов: ");
        int length = ints.length;
        Integer[] result = new Integer[length];
        for (int i = 0; i < length; i++) {
            if (ints[i] < 0) {
                System.out.println("Ошибка: факториал " + ints[i] + "! не определен");
                result[i] = null;
                continue;
            }
            System.out.print(ints[i] + "! = ");
            result[i] = 1;
            if (ints[i] != 0 && ints[i] != 1) {
                for (int j = 1; j <= ints[i]; j++) {
                    System.out.print(j);
                    result[i] *= j;
                    System.out.print(j != ints[i] ? " * " : " = ");
                }
            }
            System.out.println(result[i]);
        }
        return result;
    }
}