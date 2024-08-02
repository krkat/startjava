package com.startjava.lesson_2_3.array;

public class SortPyramidSymbols {
    public static void main(String[] args) {
        sort('0','9',true);
        sort('/','!',false);
        sort('A','J',false);
    }

    private static void sort(char start, char end, boolean asc) {
        int lines = Math.abs(end - start) + 1;
        char[] symbols = copyFromChart(start, end, asc);
        int widthPyramidBase = calcWidth(lines);
        int widthSymbolLine = widthPyramidBase;
        String[] pyramid = new String[lines];
        for (char i = 0; i < symbols.length; i++) {
            char currentSymbol = symbols[i];
            String space = buildSpaceLine(widthPyramidBase, widthSymbolLine);
            String symbolLine = buildSymbolLine(currentSymbol, widthSymbolLine);
            widthSymbolLine -= 2;
            pyramid[i] = buildLine(space, symbolLine);
        }
        output(pyramid);
    }

    private static char[] copyFromChart(char start, char end, boolean asc) {
        int lines = Math.abs(end - start) + 1;
        if (end < start) {
            char swap = end;
            end = start;
            start = swap;
        }
        char[] symbols = new char[lines];
        for (char i = 0; i < lines; i++) {
            symbols[i] = (char) (i + start);
        }
        if (!asc) {
            reverse(symbols);
        }
        return symbols;
    }

    private static void reverse(char[] symbols) {
        int i = 0;
        int j = symbols.length - 1;
        while (i < j) {
            char swap = symbols[i];
            symbols[i] = symbols[j];
            symbols[j] = swap;
            i++;
            j--;
        }
    }

    private static int calcWidth(int lines) {
        int width = 1;
        for (char i = 1; i < lines; i++) {
            width += 2;
        }
        return width;
    }

    private static String buildSpaceLine(int widthPyramid, int widthLine) {
        int spaceLength = (widthPyramid - widthLine) / 2;
        StringBuilder spaceBuilder = new StringBuilder();
        for (int j = 0; j < spaceLength; j++) {
            spaceBuilder.append(" ");
        }
        return spaceBuilder.toString();
    }

    private static String buildSymbolLine(char symbol, int width) {
        StringBuilder sb = new StringBuilder(symbol);
        for (char j = 0; j < width; j++) {
            sb.append(symbol);
        }
        return sb.toString();
    }

    private static String buildLine(String space, String symbols) {
        return new StringBuilder().append(space).append(symbols).append(space).toString();
    }

    private static void output(String[] pyramid) {
        for (int i = pyramid.length - 1; i >= 0 ; i--) {
            System.out.println(pyramid[i]);
        }
        System.out.println();
    }
}