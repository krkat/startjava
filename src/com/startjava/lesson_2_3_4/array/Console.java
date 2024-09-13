package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void print(int[] ints) {
        System.out.println(ints == null ? "null" : Arrays.toString(ints));
    }

    public static void print(StringBuilder sb) {
        System.out.println(sb);
    }

    public static void printInLines(float[] original) {
        if (original == null) {
            return;
        }
        for (int i = 0; i < original.length; i++) {
            System.out.printf("%.3f", original[i]);
            System.out.print(i != original.length - 1 ? ", " : "");
            if (i == (original.length - 1) / 2) System.out.println();
        }
        System.out.println();
    }

    public static void printInLines(int[] ints, int elementsInLine) {
        if (ints == null) {
            return;
        }
        Arrays.sort(ints);
        int counter = 0;
        for (int a : ints) {
            if (counter == elementsInLine) {
                counter = 0;
                System.out.println();
            }
            System.out.printf("%3d ", a);
            counter++;
        }
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void type(String[] words) {
        if (words == null) {
            return;
        }
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
        System.out.println("\n");
    }
}
