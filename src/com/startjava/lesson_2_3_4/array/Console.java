package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    public static void output(String message) {
        System.out.println(message);
    }

    public static void output(int[] ints) {
        System.out.println(ints == null ? "null" : Arrays.toString(ints));
    }

    public static void output(StringBuilder triangle) {
        System.out.println(triangle + "\n");
    }

    public static void output(float[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            System.out.printf("%.3f", doubles[i]);
            System.out.print(i != doubles.length - 1 ? ", " : "");
            if (i == (doubles.length - 1) / 2) System.out.println();
        }
        System.out.println();
    }

    public static void output(int[] ints, int elementsInLine) {
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
}
