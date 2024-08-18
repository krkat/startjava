package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class UniqueElementsFiller {
    public static void main(String[] args) {
        print(-10, 20, 23);
        print(-30, 10, 10);
        print(34, -34, 0);
        print(-1, 2, -3);
        print(5, -8, 2);
    }

    private static void print(int start, int end, int elementsInLine) {
        System.out.printf("%nГраницы отрезка целых чисел: %d, %d%n", start, end);
        System.out.printf("Количество чисел, выводимых в строке консоли: %d%n", elementsInLine);
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n", start, end);
            return;
        }
        if (elementsInLine <= 1) {
            System.out.printf("Ошибка: Количество чисел в строке не может быть меньше 1 (%d)%n",
                    elementsInLine);
            return;
        }
        int length = (int) ((end - start + 1) * 0.75);
        if (length <= 0) {
            System.out.printf("Ошибка: Длина массива должна быть больше 0 (%d)%n", length);
            return;
        }
        int[] uniqueInts = init(start, end, length);
        output(uniqueInts, elementsInLine);
        System.out.println();
    }

    private static int[] init(int start, int end, int length) {
        int range = end - start + 1;
        int[] uniqueInts = new int [length];
        int random;
        boolean isUnique;
        for (int i = 0; i < length; i++) {
            do {
                isUnique = true;
                random = (int) (Math.random() * range) + start;
                for (int j = 0; j < i; j++) {
                    if (uniqueInts[j] == random) {
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique);
            uniqueInts[i] = random;
        }
        return uniqueInts;
    }

    private static void output(int[] ints, int elementsInLine) {
        Arrays.sort(ints);
        int counter = 0;
        for (int a : ints) {
            if (counter == elementsInLine) {
                counter = 0;
                System.out.println();
            }
            System.out.printf("%3d ", a);
            counter++;
        }
    }
}