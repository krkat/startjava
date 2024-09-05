package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) {
        Console.output("\n1. Реверс значений массива");
        Console.output(Arrays.reverse(null));
        Console.output(Arrays.reverse(new int[0]));
        Console.output(Arrays.reverse(new int[]{6, 8, 9, 1}));
        Console.output(Arrays.reverse(new int[]{13, 8, 5, 3, 2, 1, 1}));

        Console.output("\n2. Вычисление факториала");
        Arrays.factorial();
        Arrays.factorial((int[]) null);
        Arrays.factorial(8, 0, 9);
        Arrays.factorial(-3, 1, 7, 13);
        Arrays.factorial(-22, -0);

        Console.output("\n3. Удаление элементов массива, превыщающих заданное значениею");
        float[] randomFloats = Arrays.initFloats();
        for (int indexMaxValue : new int[]{-1, 15, 0, 14}) {
            Console.output("\nИсходный массив: ");
            Console.output(randomFloats);
            Console.output(Arrays.deleteExceed(randomFloats, indexMaxValue));
        }

        Console.output("\n4. Вывод отсортированных символов в виде треугольника.");
        Console.output(Arrays.printTriangle('0', '9', true));
        Console.output(Arrays.printTriangle('/', '!', false));
        Console.output(Arrays.printTriangle('A', 'J', false));

        Console.output("\n5. Заполнение массива уникальными числами.");
        Console.output(Arrays.print(-10, 20, 23), 23);
        Console.output(Arrays.print(-30, 10, 10), 10);
        Console.output(Arrays.print(34, -34, 0), 0);
        Console.output(Arrays.print(-1, 2, -3), -3);
        Console.output(Arrays.print(5, -8, 2), 2);

        Console.output("\n6. Вывод текста с эффектом пишущей машинки.");
        Console.type(Arrays.print("Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling"));
        Console.type(Arrays.print("Чтобы написать чистый код, мы сначала пишем грязный код," +
                " затем рефакторим его.\n- Robert Martin"));
        Console.type(Arrays.print(null));
        Console.type(Arrays.print(""));
    }
}
