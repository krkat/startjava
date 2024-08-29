package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) {
        Console.output("3. Удаление элементов массива, превыщающих заданное значениею");
        float[] randomFloats = Arrays.initFloats();
        for (int indexMaxValue : new int[]{-1, 15, 0, 14}) {
            Arrays.deleteExceed(randomFloats, indexMaxValue);
        }

        Console.output("4. Вывод отсортированных символов в виде треугольника.");
        Arrays.printTriangle('0', '9', true);
        Arrays.printTriangle('/', '!', false);
        Arrays.printTriangle('A', 'J', false);


    }
}
