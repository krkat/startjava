package com.startjava.lesson_2_3.array;

public class DeletionExceedingElements {
    public static void main(String[] args) {
        float[] randomFloats = new float[15];
        initialize(randomFloats);
        for (int indexMaxValue : new int[]{-1, 15, 0, 14}) {
            deleteExceed(randomFloats, indexMaxValue);
        }
    }

    private static void initialize(float[] randomFloats) {
        for (int i = 0; i < randomFloats.length; i++) {
            randomFloats[i] = (float) Math.random();
        }
    }

    private static void deleteExceed(float[] original, int indexMaxValue) {
        System.out.println("\nИсходный массив: ");
        customOutput(original);
        deleteExceededElements(original, indexMaxValue);
    }

    private static void customOutput(float[] doubles) {
        System.out.print("[");
        for (int i = 0; i < doubles.length; i++) {
            System.out.printf("%.3f", doubles[i]);
            System.out.print(i != doubles.length - 1 ? ", " : "");
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println("]");
    }

    private static void deleteExceededElements(float[] original, int indexMaxValue) {
        System.out.println("Вычисление результирующего массива: ");
        if (isOutOfBounds(indexMaxValue, original.length)) {
            System.out.println("Результирующий массив не определен");
            return;
        }
        float maxValue = original[indexMaxValue];
        System.out.printf("Значение ячейки с индексом [%d]: %.3f%n", indexMaxValue, maxValue);
        int counterSetZero = 0;
        for (int i = 0; i < original.length; i++) {
            if (original[i] > maxValue) {
                original[i] = 0;
                counterSetZero++;
            }
        }
        System.out.println("Количество обнуленных ячеек: " + counterSetZero);
        System.out.println("Результирующий массив:");
        customOutput(original);
    }

    private static boolean isOutOfBounds(int index, int length) {
        if (index < 0 || index >= length) {
            System.out.println("Индекс [" + index + "] " + (index < 0 ?
                    "меньше 0" : "больше или равен " + length));
            return true;
        }
        return false;
    }
}