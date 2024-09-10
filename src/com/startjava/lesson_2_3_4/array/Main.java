package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) {
        Console.println("\n1. Реверс значений массива");

        int[] ints = null;
        Console.print("   До реверса: ");
        Console.print(ints);
        Console.print("После реверса: ");
        Console.print(Arrays.reverse(ints));

        ints = new int[0];
        Console.print("   До реверса: ");
        Console.print(ints);
        Console.print("После реверса: ");
        Console.print(Arrays.reverse(ints));

        ints = new int[]{6, 8, 9, 1};
        Console.print("   До реверса: ");
        Console.print(ints);
        Console.print("После реверса: ");
        Console.print(Arrays.reverse(ints));

        ints = new int[]{13, 8, 5, 3, 2, 1, 1};
        Console.print("   До реверса: ");
        Console.print(ints);
        Console.print("После реверса: ");
        Console.print(Arrays.reverse(ints));

        Console.println("\n2. Вычисление факториала");

        ints = new int[0];
        Console.print("Исходный массив: ");
        Console.print(ints);
        Console.print("Вычисление факториалов элементов: ");
        StringBuilder result = Arrays.factorial(ints);
        if (result != null) {
            Console.print(result);
        }

        ints = null;
        Console.print("Исходный массив: ");
        Console.print(ints);
        Console.print("Вычисление факториалов элементов: ");
        result = Arrays.factorial(ints);
        if (result != null) {
            Console.print(result);
        }

        ints = new int[]{8, 0, 9};
        Console.print("Исходный массив: ");
        Console.print(ints);
        Console.print("Вычисление факториалов элементов: ");
        result = Arrays.factorial(ints);
        if (result != null) {
            Console.print(result);
        }

        ints = new int[]{-3, 1, 7, 13};
        Console.print("Исходный массив: ");
        Console.print(ints);
        Console.print("Вычисление факториалов элементов: ");
        result = Arrays.factorial(ints);
        if (result != null) {
            Console.print(result);
        }

        ints = new int[]{-22, -0};
        Console.print("Исходный массив: ");
        Console.print(ints);
        Console.print("Вычисление факториалов элементов: ");
        result = Arrays.factorial(ints);
        if (result != null) {
            Console.print(result);
        }

        Console.println("\n3. Удаление элементов массива, превышающих заданное значение.");
        float[] randomFloats;
        for (int indexMaxValue : new int[]{-1, 15, 0, 14}) {
            randomFloats = Arrays.initFloats();
            Console.println("\nИсходный массив: ");
            Console.print(randomFloats);
            Console.println("Вычисление результирующего массива: ");
            int counterSetZero = Arrays.deleteExceed(randomFloats, indexMaxValue);
            if (counterSetZero != -1) {
                Console.print("Значение ячейки с индексом [%d]: %.3f%n", indexMaxValue,
                        Arrays.getValue(randomFloats, indexMaxValue));
                Console.println("Количество обнуленных ячеек: " + counterSetZero);
                Console.println("Результирующий массив:");
                Console.print(randomFloats);
            }
        }

        Console.println("\n4. Вывод отсортированных символов в виде треугольника.");

        Console.print("Границы отрезка символов: '%c' с кодом %d, '%c' с кодом %d%n",
                '0', (int) '0', '9', (int) '9');
        Console.print("Сортировка по возрастанию от основания к вершине: %b%n%n", true);
        Console.print(Arrays.formTriangle('0', '9', true));

        Console.print("Границы отрезка символов: '%c' с кодом %d, '%c' с кодом %d%n",
                '/', (int) '/', '!', (int) '!');
        Console.print("Сортировка по возрастанию от основания к вершине: %b%n%n", false);
        Console.print(Arrays.formTriangle('/', '!', false));

        Console.print("Границы отрезка символов: '%c' с кодом %d, '%c' с кодом %d%n",
                'A', (int) 'A', 'J', (int) 'J');
        Console.print("Сортировка по возрастанию от основания к вершине: %b%n%n", false);
        Console.print(Arrays.formTriangle('A', 'J', false));

        Console.println("\n5. Заполнение массива уникальными числами.");
        Console.print("%nГраницы отрезка целых чисел: %d, %d%n", -10, 20);
        Console.print("Количество чисел, выводимых в строке консоли: %d%n", 23);
        Console.print(Arrays.fill(-10, 20, 23), 23);

        Console.print("%n%nГраницы отрезка целых чисел: %d, %d%n", -30, 10);
        Console.print("Количество чисел, выводимых в строке консоли: %d%n", 10);
        Console.print(Arrays.fill(-30, 10, 10), 10);

        Console.print("%n%nГраницы отрезка целых чисел: %d, %d%n", 34, -34);
        Console.print("Количество чисел, выводимых в строке консоли: %d%n", 0);
        Console.print(Arrays.fill(34, -34, 0), 0);

        Console.print("%nГраницы отрезка целых чисел: %d, %d%n", -1, 2);
        Console.print("Количество чисел, выводимых в строке консоли: %d%n", -3);
        Console.print(Arrays.fill(-1, 2, -3), -3);

        Console.print("%nГраницы отрезка целых чисел: %d, %d%n", 5, -8);
        Console.print("Количество чисел, выводимых в строке консоли: %d%n", 2);
        Console.print(Arrays.fill(5, -8, 2), 2);

        Console.println("\n6. Вывод текста с эффектом пишущей машинки.");
        Console.type(Arrays.format("Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling"));
        Console.type(Arrays.format("Чтобы написать чистый код, мы сначала пишем грязный код," +
                " затем рефакторим его.\n- Robert Martin"));
        Console.type(Arrays.format(null));
        Console.type(Arrays.format(""));
    }
}
