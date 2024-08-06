package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class FactorialElements {
    public static void main(String[] args) {
        calcFactorial();
        int[] a = null;
        calcFactorial(a);
        calcFactorial(8, 0, 9);
        calcFactorial(-3, 1, 7, 13);
        calcFactorial(-22, -0);
    }

    private static void calcFactorial(int... ints) {
        if (ints == null) {
            System.out.println("\nОшибка! Исходный массив null");
            return;
        }
        if (ints.length == 0) {
            System.out.println("\nОшибка! Исходный массив нулевой длины");
            return;
        }
        System.out.print("\nИсходный массив: ");
        System.out.println(Arrays.toString(ints));
        calc(ints);
    }

    private static void calc(int... ints) {
        System.out.println("Вычисление факториалов элементов: ");
        for (int anInt : ints) {
            if (anInt < 0) {
                System.out.println("Ошибка: факториал " + anInt + "! не определен");
                continue;
            }
            System.out.print(anInt + "! = ");
            int factorial = 1;
            if (anInt != 0 && anInt != 1) {
                for (int j = 1; j <= anInt; j++) {
                    System.out.print(j);
                    factorial *= j;
                    System.out.print(j != anInt ? " * " : " = ");
                }
            }
            System.out.println(factorial);
        }
    }
}