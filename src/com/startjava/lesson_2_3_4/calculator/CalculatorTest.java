package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    private static final DecimalFormat decimalFormat = new DecimalFormat("###.###");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userAnswer;
        do {
            System.out.print("Введите математическое выражение: ");
            String expression = scanner.nextLine();
            Calculator calculator = new Calculator(expression);
            output(expression, calculator);
            boolean isRepeat = false;
            userAnswer = askToContinue(scanner, isRepeat).toLowerCase();
            if ("no".equals(userAnswer)) {
                break;
            }
            if (!"yes".equals(userAnswer)) {
                isRepeat = true;
                askToContinue(scanner, isRepeat);
            }
        } while ("yes".equals(userAnswer));
        System.out.println("Завершение программы.");
        scanner.close();
    }

    private static void output(String expression, Calculator calculator) {
        Double result = calculator.calculate();
        if (result.equals(Double.NaN)) {
            System.out.println("Результат не определен.");
        } else {
            System.out.println(expression + " = " + decimalFormat.format(calculator.calculate()));
        }
    }

    private static String askToContinue(Scanner scanner, boolean isRepeat) {
        System.out.print(!isRepeat ? "Хотите продолжить вычисления? [yes/no]: " :
                "Введите корректный ответ [yes/no]: ");
        return scanner.nextLine();
    }
}