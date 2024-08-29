package com.startjava.lesson_2_3_4.array;

public class Console {
    public static void output(String message) {
        System.out.println(message);
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
}
