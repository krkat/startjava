package com.startjava.lesson_2_3.array;

public class PyramidAsciiSymbols {
    public static void main(String[] args) {
        sort('0', '9', true);
        sort('/', '!', false);
        sort('A', 'J', false);
    }

    private static void sort(char start, char end, boolean asc) {
        char[] symbols = copyFromChart(start, end, asc);
        int lines = symbols.length;
        int widthSymbolLine = lines * 2 - 1;
        String[] pyramid = new String[lines];
        for (char i = 0; i < lines; i++) {
            char currentSymbol = symbols[i];
            pyramid[i] = buildSymbolLine(currentSymbol, widthSymbolLine);
            widthSymbolLine -= 2;
        }
        output(pyramid);
    }

    private static char[] copyFromChart(char start, char end, boolean asc) {
        int lines = Math.abs(end - start) + 1;
        int sign = start <= end ? 1 : -1;
        char[] symbols = new char[lines];
        int i = 0;
        while (start != end) {
            symbols[i] = start;
            start += (char) sign;
            i++;
        }
        symbols[i] = start;
        if ((symbols[0] < symbols[lines - 1] && !asc) || (symbols[0] > symbols[lines - 1] && asc)) {
            symbols = reverse(symbols);
        }
        return symbols;
    }

    private static char[] reverse(char[] symbols) {
        char[] result = new char[symbols.length];
        for (int length = symbols.length; length > 0; length--) {
            result[length - 1] = symbols[symbols.length - length];
        }
        return result;
    }

    private static String buildSymbolLine(char symbol, int width) {
        StringBuilder sb = new StringBuilder();
        for (char j = 0; j < width; j++) {
            sb.append(symbol);
        }
        return sb.toString();
    }

    private static void output(String[] pyramid) {
        int widthBase = pyramid.length * 2 - 1;
        for (int i = pyramid.length - 1; i >= 0; i--) {
            int lengthSpace = (widthBase - pyramid[i].length()) / 2;
            StringBuilder spaceBuilder = new StringBuilder();
            for (i = 0; i < lengthSpace; i++) {
                spaceBuilder.append(" ");
            }
            System.out.printf("%s%s%n", spaceBuilder, pyramid[i]);
        }
        System.out.println();
    }
}