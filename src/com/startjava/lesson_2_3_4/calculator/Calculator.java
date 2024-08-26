package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private int x;
    private int y;
    private String sign;

    public Calculator(String expression) {
        String[] operandsAndSigns = expression.split(" ");
        setX(Integer.parseInt(operandsAndSigns[0]));
        setSign(operandsAndSigns[1]);
        setY(Integer.parseInt(operandsAndSigns[2]));
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
            sign = String.valueOf(Double.NaN);
        }
        this.sign = sign;
    }

    public double calculate() {
        return switch (sign) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "^" -> Math.pow(x, y);
            case "/" -> (double) x / y;
            case "%" -> {
                if (y == 0) {
                    yield Double.NaN;
                }
                yield Math.floorMod(x, y);
            }
            default -> Double.NaN;
        };
    }
}