package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class UniqueElements {
    public static void main(String[] args) {
        method(-10, 20, 23);
        method(-30, 10, 10);
        method(34, -34, 0);
        method(-1, 2, -3);
    }

    private static void method(int start, int end, int elementsInLine) {
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
        int[] array = init(start, end, length);
        output(array, elementsInLine);
        System.out.println();
    }

    private static int[] init(int start, int end, int length) {
        int[] array = new int [length];
        int random;
        boolean isRepeat;
        for (int i = 0; i < length; i++) {
            do {
                isRepeat = false;
                random = (int) (Math.random() * length) + (Math.min(start, end));
                for (int j = 0; j < i; j++) {
                    if (array[j] == random) {
                        isRepeat = true;
                        break;
                    }
                }
            } while (isRepeat);
            array[i] = random;
        }
        return array;
    }

    private static void output(int[] array, int elementsInLine) {
        Arrays.sort(array);
        for (int i = 0; i < elementsInLine; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}