package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) {
        Console.println("\n1. Реверс значений массива");
        int[] ints = null;
        task1(ints);
        task1(new int[0]);
        task1(new int[]{6, 8, 9, 1});
        task1(new int[]{13, 8, 5, 3, 2, 1, 1});

        Console.println("\n2. Вычисление факториала");
        task2(new int[0]);
        ints = null;
        task2(ints);
        task2(new int[]{8, 0, 9});
        task2(new int[]{-3, 1, 7, 13});
        task2(new int[]{-22, -0});

        Console.println("\n3. Удаление элементов массива, превышающих заданное значение.");
        for (int indexMaxValue : new int[]{-1, 15, 0, 14}) {
            task3(indexMaxValue);
        }

        Console.println("\n4. Вывод отсортированных символов в виде треугольника.");
        task4('0', '9', true);
        task4('/', '!', false);
        task4('A', 'J', false);

        Console.println("\n5. Заполнение массива уникальными числами.");
        task5(-10, 20, 23);
        task5(-30, 10, 10);
        task5(34, -34, 0);
        task5(-1, 2, -3);
        task5(5, -8, 2);

        Console.println("\n6. Вывод текста с эффектом пишущей машинки.");
        Console.type(Arrays.extractWords("Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling"));
        Console.type(Arrays.extractWords("Чтобы написать чистый код, мы сначала пишем грязный код," +
                " затем рефакторим его.\n- Robert Martin"));
        Console.type(Arrays.extractWords(null));
        Console.type(Arrays.extractWords(""));
    }

    private static void task1(int[] ints) {
        Console.print("   До реверса: ");
        Console.print(ints);
        Console.print("После реверса: ");
        Console.print(Arrays.reverse(ints));
    }

    private static void task2(int[] ints) {
        Console.print("Исходный массив: ");
        Console.print(ints);
        Console.print("Вычисление факториалов элементов: ");
        String result = Arrays.factorial(ints);
        if (result != null) {
            Console.print(result);
        }
    }

    private static void task3(int indexMaxValue) {
        float[] randomFloats = Arrays.initFloats();
        Console.println("\nИсходный массив: ");
        Console.printInLines(randomFloats);
        Console.println("Вычисление результирующего массива: ");
        int counterSetZero = Arrays.deleteExceed(randomFloats, indexMaxValue);
        if (counterSetZero != -1) {
            Console.printf("Значение ячейки с индексом [%d]: %.3f%n", indexMaxValue,
                    randomFloats[indexMaxValue]);
            Console.println("Количество обнуленных ячеек: " + counterSetZero);
            Console.println("Результирующий массив:");
            Console.printInLines(randomFloats);
        }
    }

    private static void task4(char start, char end, boolean asc) {
        Console.printf("Границы отрезка символов: '%c' с кодом %d, '%c' с кодом %d%n",
                start, (int) start, end, (int) end);
        Console.printf("Сортировка по возрастанию от основания к вершине: %b%n%n", asc);
        Console.print(Arrays.formTriangle(start, end, true));
    }

    private static void task5(int start, int end, int numbersInLine) {
        Console.printf("%nГраницы отрезка целых чисел: %d, %d%n", start, end);
        Console.printf("Количество чисел, выводимых в строке консоли: %d%n", numbersInLine);
        Console.printInLines(Arrays.fill(start, end, numbersInLine), numbersInLine);

    }
}
