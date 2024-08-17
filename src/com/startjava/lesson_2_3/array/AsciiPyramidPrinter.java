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
        for (char symbol : symbols) {
            numberSpaces = (widthPyramidBase - numberLineSymbols) / 2;
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < numberSpaces; j++) {
                line.append(" ");
            }
            for (int j = 0; j < numberLineSymbols; j++) {
                line.append(symbol);
            }
            System.out.println(line);
            numberLineSymbols += 2;
        }
        System.out.println();
    }

    private static char[] init(char start, char end, boolean asc) {
        char[] symbols = new char[end - start + 1];
        for (char i = start; i <= end; i++) {
            symbols[i - start] = i;
        }
        if (asc) {
            reverse(symbols);
        }
        return symbols;
    }

    private static void reverse(char[] symbols) {
        int len = symbols.length;
        for (int i = 0; i < len - 1; i++) {
            char swap = symbols[i];
            symbols[i] = symbols[--len];
            symbols[len] = swap;
        }
    }
}