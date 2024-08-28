package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    private static final DecimalFormat decimalFormat = new DecimalFormat("###.###");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userAnswer = "yes";
        boolean isRepeat;
        do {
            String expression;
            if ("yes".equals(userAnswer)) {
                System.out.print("Введите математическое выражение: ");
                expression = scanner.nextLine();
                Calculator calculator = new Calculator(expression);
                output(expression, calculator.calculate());
                isRepeat = false;
            } else {
                isRepeat = true;
            }
            userAnswer = askToContinue(scanner, isRepeat).toLowerCase();
        } while (!"no".equals(userAnswer));
        System.out.println("Завершение программы.");
        scanner.close();
    }

    private static void output(String expression, Double result) {
        if (result.equals(Double.NaN)) {
            System.out.println("Результат не определен.");
        } else {
            System.out.println(expression + " = " + decimalFormat.format(result));
        }
    }

    private static String askToContinue(Scanner scanner, boolean isRepeat) {
        System.out.print(!isRepeat ? "Хотите продолжить вычисления? [yes/no]: " :
                "Введите корректный ответ [yes/no]: ");
        return scanner.nextLine();
    }
}