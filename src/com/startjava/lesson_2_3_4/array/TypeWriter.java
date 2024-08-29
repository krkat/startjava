package com.startjava.lesson_2_3_4.array;

public class TypeWriter {
    public static void main(String[] args) {
        print("Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling");
        print("Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin");
        print(null);
        print("");
    }

    private static void print(String text) {
        if (text == null) {
            System.out.println("Ошибка: текст == null\n");
            return;
        }
        if (text.isBlank()) {
            System.out.println("Ошибка: пустая строка\n");
            return;
        }
        String[] words = text.split(" ");
        output(words, indexOfMin(words), indexOfMax(words));
        System.out.println();
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
        return isMax ? noPunctuation.length() > resultLength : !noPunctuation.isEmpty() && noPunctuation.length() < resultLength;
    }

    private static void output(String[] words, int indexMinWord, int indexMaxWord) {
        boolean isUpperCase = false;
        int start = Math.min(indexMinWord, indexMaxWord);
        int end = Math.max(indexMinWord, indexMaxWord);
        for (int i = start; i <= end; i++) {
            words[i] = words[i].toUpperCase();
        }
        type(words);
        System.out.println();
    }

    private static void type(String[] words) {
        for (String word : words) {
            for (char symbol : word.toCharArray()) {
                try {
                    System.out.print(symbol);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.exit(1);
                }
            }
            System.out.print(" ");
        }
    }
}