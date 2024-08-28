package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private int x;
    private int y;
    private String sign;

    public Calculator(String expression) {
        String[] elements = expression.split(" ");
        setX(Integer.parseInt(elements[0]));
        setSign(elements[1]);
        setY(Integer.parseInt(elements[2]));
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSign(String sign) {
        if (!sign.equals("+") && !sign.equals("-") && !sign.equals("*") &&
                !sign.equals("/") && !sign.equals("^") && !sign.equals("%")) {
            System.out.println("Ошибка: операция '" + sign + "' не поддерживается.");
            System.out.println("Доступны следующие операции: +. -, *. /, ^. %");
        }
        this.sign = sign;
    }

    public double calculate() {
        return switch (sign) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "^" -> Math.pow(x, y);
            case "/", "%" -> {
                if (y == 0) {
                    System.out.println("Ошибка: Деление на 0 запрещено.");
                    yield Double.NaN;
                }
                yield divOrMod(x, y, sign);
            }
            default -> Double.NaN;
        };
    }

    private static Double divOrMod(int x, int y, String sign) {
        return "/".equals(sign) ? (double) x / y : Math.floorMod(x, y);
    }
}