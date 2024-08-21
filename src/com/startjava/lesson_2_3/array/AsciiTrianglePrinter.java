package com.startjava.lesson_2_3.array;

public class AsciiPyramidPrinter {
    public static void main(String[] args) {
        print('0', '9', true);
        print('/', '!', false);
        print('A', 'J', false);
    }

    private static void print(char start, char end, boolean asc) {
        System.out.printf("Границы отрезка символов: '%c' с кодом %d, '%c' с кодом %d%n",
                start, (int) start, end, (int) end);
        System.out.printf("Сортировка по возрастанию от основания к вершине: %b%n%n", asc);
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", (int) start, (int) end);
            return;
        }
        char[] symbols = init(start, end, asc);
        int widthPyramidBase = symbols.length * 2 - 1;
        int numberLineSymbols = 1;
        int numberSpaces;
        StringBuilder line = new StringBuilder();
        for (char symbol : symbols) {
            numberSpaces = (widthPyramidBase - numberLineSymbols) / 2;
            line.append(" ".repeat(numberSpaces));
            line.append(String.valueOf(symbol).repeat(numberLineSymbols));
            line.append("\n");
            numberLineSymbols += 2;
        }
        System.out.println(line);
        System.out.println();
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