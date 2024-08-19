package com.startjava.lesson_2_3.array;

import java.util.Arrays;

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
        String[] words = extractWords(text);
        String[] delimiters = extractDelimiters(text);
        String[] textLines = concat(delimiters, words);
        type(textLines, min(words), max(words));
        System.out.println();
    }

    private static String[] extractWords(String text) {
        String[] words = text.split("[^a-zA-Zа-яА-Я+]+");
        if (words[0].isEmpty()) {
            words = Arrays.copyOfRange(words, 1, words.length);
        }
        return words;
    }

    private static String[] extractDelimiters(String text) {
        return text.split("[a-zA-Zа-яА-Я+]+");
    }

    private static String[] concat(String[] delimiters, String[] words) {
        if (delimiters == null || delimiters.length == 0) {
            return words;
        }
        if (words == null || words.length == 0) {
            return delimiters;
        }
        String[] result = new String[delimiters.length + words.length];
        int indexResult = 0;
        for (int i = 0; i < delimiters.length; i++) {
            result[indexResult] = delimiters[i];
            indexResult++;
            if (i == words.length) {
                break;
            }
            result[indexResult] = words[i];
            indexResult++;
        }
        return result;
    }

    private static String max(String[] words) {
        return findMinOrMax(words, true);
    }

    private static String min(String[] words) {
        return findMinOrMax(words, false);
    }

    private static String findMinOrMax(String[] words, boolean findMax) {
        String result = words[0];
        for (String word : words) {
            if (findMax ? word.length() > result.length() : word.length() < result.length()) {
                result = word;
            }
        }
        return result;
    }

    private static void type(String[] words, String minWord, String maxWord) {
        boolean isUpperCase = false;
        for (String word : words) {
            if (word.equals(minWord) || word.equals(maxWord)) {
                typeWord(word.toUpperCase());
                isUpperCase = !isUpperCase;
                continue;
            }
            typeWord(isUpperCase ? word.toUpperCase() : word);
        }
        System.out.println();
    }

    private static void typeWord(String word) {
        for (char symbol : word.toCharArray()) {
            try {
                System.out.print(symbol);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.exit(1);
            }
        }
    }
}