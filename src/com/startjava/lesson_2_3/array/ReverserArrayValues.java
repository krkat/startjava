package com.startjava.lesson_2_3.array;

public class ReverserArrayValues {
    public static void main(String[] args) {
        int[] ints1 = {6, 8, 9, 1};
        int[] ints2 = {13, 8, 5, 3, 2, 1, 1};
        reverseValues(null);
        reverseValues(new int[0]);
        reverseValues(ints1);
        reverseValues(ints2);
    }

    private static void reverseValues(int[] ints) {
        System.out.print("   До реверса: ");
        output(ints);
        System.out.print("После реверса: ");
        output(reverse(ints));
    }

    private static int[] reverse(int[] ints) {
        if (ints == null || ints.length == 0) {
            return ints;
        }
        int start = 0;
        int end = ints.length - 1;
        while (start < end) {
            int temp = ints[start];
            ints[start] = ints[end];
            ints[end] = temp;
            start++;
            end--;
        }
        return ints;
    }

    private static void output(int[] ints) {
        if (ints == null) {
            System.out.println("null");
            return;
        }
        int length = ints.length;
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(ints[i]);
            if (i != length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
