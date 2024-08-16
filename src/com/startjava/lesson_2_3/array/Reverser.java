package com.startjava.lesson_2_3.array;

import java.util.Arrays;

public class Reverser {
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
        reverseValues(ints);
        output(ints);
    }

    private static void reverseValues(int[] ints) {
        if (ints != null && ints.length != 0) {
            for (int length = ints.length; length > ints.length / 2; length--) {
                int swap = ints[length - 1];
                ints[length - 1] = ints[ints.length - length];
                ints[ints.length - length] = swap;
            }
        }
    }

    private static void output(int[] ints) {
        System.out.println(ints == null ? "null" : Arrays.toString(ints));
    }
}