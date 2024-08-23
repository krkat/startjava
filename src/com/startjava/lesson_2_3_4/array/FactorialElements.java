package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class FactorialElements {
    public static void main(String[] args) {
        factorial();
        factorial((int[]) null);
        factorial(8, 0, 9);
        factorial(-3, 1, 7, 13);
        factorial(-22, -0);
    }

    private static void factorial(int... ints) {
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
            if (anInt > 1) {
                for (int i = 1; i <= anInt; i++) {
                    System.out.print(i);
                    factorial *= i;
                    System.out.print(i != anInt ? " * " : " = ");
                }
            }
            System.out.println(factorial);
        }
    }
}