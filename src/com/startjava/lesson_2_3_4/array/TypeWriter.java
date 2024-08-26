package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TypeWriter {
    public static void main(String[] args) {
        print(" . ");
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
        String[] words = extractWords(text);
        output(text, words, min(words), max(words));
        System.out.println();
    }

    private static String[] extractWords(String text) {
        String[] words = text.split("[\\p{P} \n]+");
        if (words.length != 0 && words[0].isEmpty()) {
            words = Arrays.copyOfRange(words, 1, words.length);
        }
        return words;
    }

    private static String max(String[] words) {
        return findMinOrMax(words, true);
    }

    private static String min(String[] words) {
        return findMinOrMax(words, false);
    }

    private static String findMinOrMax(String[] words, boolean findMax) {
        if (words.length == 0) {
            return null;
        }
        String result = words[0];
        for (String word : words) {
            if (findMax ? word.length() > result.length() : word.length() < result.length()) {
                result = word;
            }
        }
        return result;
    }

    private static void output(String text, String[] words, String minWord, String maxWord) {
        boolean isUpperCase = false;
        for (String word : words) {
            if (word.equalsIgnoreCase(minWord) || word.equalsIgnoreCase(maxWord)) {
                text = text.replaceFirst(word, word.toUpperCase());
                isUpperCase = !isUpperCase;
                continue;
            }
            if (isUpperCase) {
                text = text.replace(word, word.toUpperCase());
            }
        }
        type(text);
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