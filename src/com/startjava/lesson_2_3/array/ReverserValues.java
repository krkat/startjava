package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class ReverserValues {
    public static void main(String[] args) {
        reverse(null);
        reverse(new int[0]);
        reverse(new int[]{6, 8, 9, 1});
        reverse(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    private static void reverse(int[] ints) {
        System.out.print("   До реверса: ");
        output(ints);
        System.out.print("После реверса: ");
        output(reverseValues(ints));
    }

    private static int[] reverseValues(int[] ints) {
        if (ints == null || ints.length == 0) {
            return ints;
        }
        int length = ints.length;
        for (int i = 0; i < length / 2; i++) {
            int swap = ints[i];
            ints[i] = ints[length - i - 1];
            ints[length - i - 1] = swap;
        }
        return ints;
    }

    private static void output(int[] ints) {
        if (ints == null) {
            System.out.println("null");
            return;
        }
        System.out.println(Arrays.toString(ints));
    }
}