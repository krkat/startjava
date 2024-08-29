package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) {
        Console.output("\n1. Реверс значений массива");
        Arrays.reverse(null);
        Arrays.reverse(new int[0]);
        Arrays.reverse(new int[]{6, 8, 9, 1});
        Arrays.reverse(new int[]{13, 8, 5, 3, 2, 1, 1});

        Console.output("\n3. Удаление элементов массива, превыщающих заданное значениею");
        float[] randomFloats = Arrays.initFloats();
        for (int indexMaxValue : new int[]{-1, 15, 0, 14}) {
            Arrays.deleteExceed(randomFloats, indexMaxValue);
        }

        Console.output("\n4. Вывод отсортированных символов в виде треугольника.");
        Arrays.printTriangle('0', '9', true);
        Arrays.printTriangle('/', '!', false);
        Arrays.printTriangle('A', 'J', false);

        Console.output("\n5. Заполнение массива уникальными числами.");
        Arrays.print(-10, 20, 23);
        Arrays.print(-30, 10, 10);
        Arrays.print(34, -34, 0);
        Arrays.print(-1, 2, -3);
        Arrays.print(5, -8, 2);

    }
}
