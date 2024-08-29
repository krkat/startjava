package com.startjava.lesson_2_3_4.array;

public class Arrays {
    public static void printTriangle(char start, char end, boolean asc) {
        System.out.printf("Границы отрезка символов: '%c' с кодом %d, '%c' с кодом %d%n",
                start, (int) start, end, (int) end);
        System.out.printf("Сортировка по возрастанию от основания к вершине: %b%n%n", asc);
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", (int) start, (int) end);
            return;
        }
        StringBuilder triangle = formTriangle(start, end, asc);
        Console.output(triangle);
    }

    public static StringBuilder formTriangle(char start, char end, boolean asc) {
        char[] symbols = init(start, end, asc);
        int widthPyramidBase = symbols.length * 2 - 1;
        int numberLineSymbols = 1;
        int numberSpaces;
        StringBuilder triangle = new StringBuilder();
        for (char symbol : symbols) {
            numberSpaces = (widthPyramidBase - numberLineSymbols) / 2;
            triangle.append(" ".repeat(numberSpaces));
            triangle.append(String.valueOf(symbol).repeat(numberLineSymbols));
            triangle.append("\n");
            numberLineSymbols += 2;
        }
        return triangle;
    }

    private static char[] init(char start, char end, boolean asc) {
        char[] symbols = new char[end - start + 1];
        int increment = asc ? 1 : -1;
        int index = asc ? 0 : end - start;
        for (char i = start; i <= end; i++) {
            symbols[index] = i;
            index += increment;
        }
        return symbols;
    }
}