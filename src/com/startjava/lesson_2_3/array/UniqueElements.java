package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class UniqueElements {
    public static void main(String[] args) {
        print(-10, 20, 23);
        print(-30, 10, 10);
        print(34, -34, 0);
        print(-1, 2, -3);
    }

    private static void print(int start, int end, int elementsInLine) {
        System.out.printf("Границы отрезка целых чисел: %d, %d%n", start, end);
        System.out.printf("Количество чисел, выводимых в строке консоли: %d%n", elementsInLine);
        if (elementsInLine <= 1) {
            System.out.printf("Ошибка: Количество чисел в строке не может быть меньше 1 (%d)%n%n",
                    elementsInLine);
            return;
        }
        int length = (int) ((start >= end ? start - end + 1 : end - start + 1) * 0.75);
        if (length <= 0) {
            System.out.printf("Ошибка: Длина массива должна быть больше 0 (%d)%n%n", length);
            return;
        }
        int[] uniqueInts = init(start, end, length);
        output(uniqueInts, elementsInLine);
        System.out.println();
    }

    private static int[] init(int start, int end, int length) {
        int[] uniqueInts = new int [length];
        int random;
        boolean isRepeat;
        for (int i = 0; i < length; i++) {
            do {
                isRepeat = false;
                random = (int) (Math.random() * length) + (Math.min(start, end));
                for (int j = 0; j < i; j++) {
                    if (uniqueInts[j] == random) {
                        isRepeat = true;
                        break;
                    }
                }
            } while (isRepeat);
            uniqueInts[i] = random;
        }
        return uniqueInts;
    }

    private static void output(int[] ints, int elementsInLine) {
        Arrays.sort(ints);
        for (int i = 0; i < elementsInLine; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }
}