package com.startjava.lesson_2_3.array;

public class AsciiPyramidPrinter {
    public static void main(String[] args) {
        print('0', '9', true);
        print('/', '!', false);
        print('A', 'J', false);
    }

    private static void print(char start, char end, boolean asc) {
        char[] symbols = init(start, end, asc);
        int lines = symbols.length;
        int widthPyramidBase = lines * 2 - 1;
        int numberLineSymbols = 1;
        int numberSpaces;
        for (char symbol : symbols) {
            numberSpaces = (widthPyramidBase - numberLineSymbols) / 2;
            for (int j = 0; j < numberSpaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < numberLineSymbols; j++) {
                System.out.print(symbol);
            }
            System.out.println();
            numberLineSymbols += 2;
        }
        System.out.println();
    }

    private static char[] init(char start, char end, boolean asc) {
        if (start > end) {
            char swap = start;
            start = end;
            end = swap;
        }
        int lines = Math.abs(end - start) + 1;
        char[] symbols = new char[lines];
        for (char i = start; i <= end; i++) {
            symbols[i - start] = i;
        }
        if (asc) {
            reverse(symbols);
        }
        return symbols;
    }

    private static void reverse(char[] symbols) {
        for (int length = symbols.length - 1; length >= symbols.length / 2; length--) {
            char swap = symbols[length];
            symbols[length] = symbols[symbols.length - length - 1];
            symbols[symbols.length - length - 1] = swap;
        }
    }
}