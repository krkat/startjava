package com.startjava.lesson_2_3_4.array;

public class Arrays {

    public static int[] reverse(int[] ints) {
        System.out.print("   До реверса: ");
        Console.output(ints);
        System.out.print("После реверса: ");
        if (ints != null) {
            int len = ints.length;
            for (int i = 0; i < len - 1; i++) {
                int swap = ints[i];
                ints[i] = ints[--len];
                ints[len] = swap;
            }
        }
        return ints;
    }

    public static void factorial(int... ints) {
        if (ints == null) {
            System.out.println("\nОшибка! Исходный массив null");
            return;
        }
        if (ints.length == 0) {
            System.out.println("\nОшибка! Исходный массив нулевой длины");
            return;
        }
        System.out.println("\nИсходный массив: ");
        System.out.println(java.util.Arrays.toString(ints));
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

    public static StringBuilder printTriangle(char start, char end, boolean asc) {
        System.out.printf("Границы отрезка символов: '%c' с кодом %d, '%c' с кодом %d%n",
                start, (int) start, end, (int) end);
        System.out.printf("Сортировка по возрастанию от основания к вершине: %b%n%n", asc);
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", (int) start, (int) end);
            return new StringBuilder();
        }

        char[] symbols = new char[end - start + 1];
        int increment = asc ? 1 : -1;
        int index = asc ? 0 : end - start;
        for (char i = start; i <= end; i++) {
            symbols[index] = i;
            index += increment;
        }

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

    public static float[] initFloats() {
        float[] randomFloats = new float[15];
        for (int i = 0; i < randomFloats.length; i++) {
            randomFloats[i] = (float) Math.random();
        }
        return randomFloats;
    }

    public static float[] deleteExceed(float[] original, int indexMaxValue) {
        System.out.println("Вычисление результирующего массива: ");
        if (isOutOfBounds(indexMaxValue, original.length)) {
            System.out.println("Результирующий массив не определен");
            return null;
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
        return original;
    }

    private static boolean isOutOfBounds(int index, int length) {
        if (index < 0 || index >= length) {
            System.out.println("Индекс [" + index + "] " + (index < 0 ?
                    "меньше 0" : "больше или равен " + length));
            return true;
        }
        return false;
    }

    public static int[] print(int start, int end, int elementsInLine) {
        System.out.printf("%nГраницы отрезка целых чисел: %d, %d%n", start, end);
        System.out.printf("Количество чисел, выводимых в строке консоли: %d%n", elementsInLine);
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n", start, end);
            return null;
        }
        if (elementsInLine <= 1) {
            System.out.printf("Ошибка: Количество чисел в строке не может быть меньше 1 (%d)%n",
                    elementsInLine);
            return null;
        }
        int length = (int) ((end - start + 1) * 0.75);
        if (length <= 0) {
            System.out.printf("Ошибка: Длина массива должна быть больше 0 (%d)%n", length);
            return null;
        }

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

    public static String[] print(String text) {
        if (text == null) {
            System.out.println("Ошибка: текст == null\n");
            return null;
        }
        if (text.isBlank()) {
            System.out.println("Ошибка: пустая строка\n");
            return null;
        }
        String[] words = text.split(" ");

        int indexMinWord = indexOfMin(words);
        int indexMaxWord = indexOfMax(words);

        int start = Math.min(indexMinWord, indexMaxWord);
        int end = Math.max(indexMinWord, indexMaxWord);
        for (int i = start; i <= end; i++) {
            words[i] = words[i].toUpperCase();
        }
        return words;
    }

    private static int indexOfMax(String[] words) {
        return findExtreme(words, true);
    }

    private static int indexOfMin(String[] words) {
        return findExtreme(words, false);
    }

    private static int findExtreme(String[] words, boolean isMax) {
        if (words.length == 0) {
            return 0;
        }
        int index = 0;
        String noPunctuation = words[0];
        int resultLength = noPunctuation.length();
        for (int i = 0; i < words.length; i++) {
            noPunctuation = words[i].replaceAll("[\\p{P}\\s]+", "");
            if (canBeExtreme(isMax, noPunctuation, resultLength)) {
                resultLength = words[i].length();
                index = i;
            }
        }
        return index;
    }

    private static boolean canBeExtreme(boolean isMax, String noPunctuation, int resultLength) {
        return isMax ? noPunctuation.length() > resultLength :
                !noPunctuation.isEmpty() && noPunctuation.length() < resultLength;
    }
}