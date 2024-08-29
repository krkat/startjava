package com.startjava.lesson_2_3_4.array;

public class Arrays {

    public static void reverse(int[] ints) {
        System.out.print("   До реверса: ");
        Console.output(ints);
        System.out.print("После реверса: ");
        reverseValues(ints);
        Console.output(ints);
    }

    private static void reverseValues(int[] ints) {
        if (ints != null) {
            int len = ints.length;
            for (int i = 0; i < len - 1; i++) {
                int swap = ints[i];
                ints[i] = ints[--len];
                ints[len] = swap;
            }
        }
    }

    public static void printTriangle(char start, char end, boolean asc) {
        System.out.printf("Границы отрезка символов: '%c' с кодом %d, '%c' с кодом %d%n",
                start, (int) start, end, (int) end);
        System.out.printf("Сортировка по возрастанию от основания к вершине: %b%n%n", asc);
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", (int) start, (int) end);
            return;
        }
        StringBuilder triangle = formTriangle(start, end, asc);
        Console.output(triangle);
    }

    public static StringBuilder formTriangle(char start, char end, boolean asc) {
        char[] symbols = init(start, end, asc);
        int widthPyramidBase = symbols.length * 2 - 1;
        int numberLineSymbols = 1;
        int numberSpaces;
        StringBuilder triangle = new StringBuilder();
        for (char symbol : symbols) {
            numberSpaces = (widthPyramidBase - numberLineSymbols) / 2;
            triangle.append(" ".repeat(numberSpaces));
            triangle.append(String.valueOf(symbol).repeat(numberLineSymbols));
            triangle.append("\n");
            numberLineSymbols += 2;
        }
        return triangle;
    }

    private static char[] init(char start, char end, boolean asc) {
        char[] symbols = new char[end - start + 1];
        int increment = asc ? 1 : -1;
        int index = asc ? 0 : end - start;
        for (char i = start; i <= end; i++) {
            symbols[index] = i;
            index += increment;
        }
        return symbols;
    }

    public static float[] initFloats() {
        float[] randomFloats = new float[15];
        for (int i = 0; i < randomFloats.length; i++) {
            randomFloats[i] = (float) Math.random();
        }
        return randomFloats;
    }

    public static void deleteExceed(float[] original, int indexMaxValue) {
        System.out.println("\nИсходный массив: ");
        Console.output(original);
        deleteExceededElements(original, indexMaxValue);
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
        Console.output(original);
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