package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class DeletionExceedingElements {
    public static void main(String[] args) {
        double[] doubles = new double[15];
        initialize(doubles);
        for(int indexMaxValue : new int[]{-1, 15, 0, 14}) {
            deleteExceed(doubles, indexMaxValue);
        }
    }

    private static void initialize(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Math.random();
        }
    }

    private static void deleteExceed(double[] original, int indexMaxValue) {
        System.out.println("\nИсходный массив: ");
        customOutput(original);
        deleteExceededElements(original, indexMaxValue);
    }

    private static void customOutput(double[] doubles) {
        double[] part1 = Arrays.copyOfRange(doubles, 0, 8);
        double[] part2 = Arrays.copyOfRange(doubles, 8, 15);
        System.out.print("[");
        formattedOutput(part1);
        System.out.println();
        formattedOutput(part2);
        System.out.println("]");
    }

    private static void formattedOutput(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            System.out.printf("%.3f", doubles[i]);
            System.out.print(i != doubles.length - 1 ? ", " : "");
        }
    }

    private static void deleteExceededElements(double[] original, int indexMaxValue) {
        System.out.println("Вычисление результирующего массива: ");
        if (checkIndexOutOfBounds(indexMaxValue, original.length)) {
            System.out.println("Результирующий массив не определен");
            return;
        }
        double maxValue = original[indexMaxValue];
        System.out.printf("Значение ячейки с индексом [%d]: %.3f%n", indexMaxValue, maxValue);
        int counterSetZero = 0;
        double[] result = Arrays.copyOf(original, original.length);
        for (int i = 0; i < result.length; i++) {
            if (result[i] > maxValue) {
                result[i] = 0;
                counterSetZero++;
            }
        }
        System.out.println("Количество обнуленных ячеек: " + counterSetZero);
        System.out.println("Результирующий массив:");
        customOutput(result);
    }

    private static boolean checkIndexOutOfBounds(int index, int length) {
        if (index < 0 || index >= length) {
            System.out.println("Индекс [" + index + "] " + (index < 0 ? "меньше 0" : "больше или равен " + length));
            return true;
        }
        return false;
    }
}