package com.startjava.lesson_2_3_4.calculator;

import java.lang.Math;

public class Calculator {    

    private int x;
    private int y;
    private char sign;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean setSign(char sign) {
        if (sign != '+' && sign != '-' && sign != '*' && 
                sign != '/' && sign != '^' && sign != '%') {
            System.out.println("Ошибка: операция '" + sign + "' не поддерживается.");
            System.out.println("Доступны следующие операции: +. -, *. /, ^. %");
            return false;
        }
        this.sign = sign;
        return true;
    }

    public void calculate() {
        double result; 
        switch (sign) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '^':
                result = pow(x, y); 
                break;
            case '/':
            case '%':
                if (y == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return;
                }
                result = divOrMod();
                break;
            default:
                System.out.println("Ошибка: операция не поддерживается.");
                return; 
        }
        System.out.println(result);       
    }

    private double pow(int x, int y) {
        double result = 1; 
        for (int i = 1; i <= Math.abs(y); i++) {
            result *= x;
        }
        return y >= 0 ? result : 1 / result;
    }

    private double divOrMod() {
        return sign == '/' ? (double) x / y : x % y;
    }
}