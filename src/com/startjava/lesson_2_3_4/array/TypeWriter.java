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
        return findMinOrMax(words, true);
    }

    private static int indexOfMin(String[] words) {
        return findMinOrMax(words, false);
    }

    private static int findMinOrMax(String[] words, boolean findMax) {
        if (words.length == 0) {
            return 0;
        }
        int index = 0;
        String word = words[0].replaceAll("[\\p{P} \n]+", "");
        int resultLength = word.length();
        for (int i = 0; i < words.length; i++) {
            word = words[i].replaceAll("[\\p{P} \n]+", "");
            if (findMax ? word.length() > resultLength : !word.isEmpty() && word.length() < resultLength) {
                resultLength = words[i].length();
                index = i;
            }
        }
        return index;
    }

    private static void output(String[] words, int indexMinWord, int indexMaxWord) {
        boolean isUpperCase = false;
        for (int i = 0; i < words.length; i++) {
            if (i == indexMinWord || i == indexMaxWord) {
                words[i] = words[i].toUpperCase();
                type(words[i]);
                System.out.print(" ");
                isUpperCase = !isUpperCase;
                continue;
            }
            if (isUpperCase) {
                words[i] = words[i].toUpperCase();
            }
            type(words[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void type(String word) {
        for (char symbol : word.toCharArray()) {
            try {
                System.out.print(symbol);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.exit(1);
            }
        }
    }
}