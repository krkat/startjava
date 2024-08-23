package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private int x;
    private int y;
    private String sign;

    public void setX(int x) {
        this.x = x;
    }

    public Calculator(String[] operandsAndSigns) {
        setX(Integer.parseInt(operandsAndSigns[0]));
        setSign(operandsAndSigns[1]);
        setY(Integer.parseInt(operandsAndSigns[2]));
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
        double result; 
        switch (sign) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "^":
                result = Math.pow(x, y);
                break;
            case "/":
                result = (double) x / y;
                break;
            case "%":
                if (y == 0) {
                    return Double.NaN;
                }
                result = Math.floorMod(x, y);
                break;
            case "NaN":
            default:
                return Double.NaN;
        }
        return result;
    }
}