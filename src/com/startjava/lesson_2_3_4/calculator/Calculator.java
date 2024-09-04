package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int NUMBER_ELEMENTS = 3;

    public static double calculate(String expression) {
        String[] elements = expression.split(" ");
        if (elements.length != NUMBER_ELEMENTS) {
            throw new RuntimeException("Ошибка: количество элементов выражения неверное.");
        }
        int x;
        int y;
        try {
            x = Integer.parseInt(elements[0]);
            y = Integer.parseInt(elements[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Ошибка: введены не целые числа");
        }
        String sign = elements[1];
        return switch (sign) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "^" -> Math.pow(x, y);
            case "/", "%" -> {
                if (y == 0) {
                    throw new RuntimeException("Ошибка: Деление на 0 запрещено.");
                }
                yield divOrMod(x, y, sign);
            }
            default -> throw new RuntimeException("Ошибка: операция '" + sign + "' не поддерживается." +
                    "\nДоступны следующие операции: +. -, *. /, ^. %");
        };
    }

    private static Double divOrMod(int x, int y, String sign) {
        return "/".equals(sign) ? (double) x / y : Math.floorMod(x, y);
    }
}