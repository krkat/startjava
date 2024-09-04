package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    private static final DecimalFormat df = new DecimalFormat("###.###");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userAnswer = "yes";
        boolean isWrongAnswer;
        do {
            if ("yes".equals(userAnswer)) {
                System.out.print("Введите математическое выражение: ");
                String expression = scanner.nextLine().trim().replaceAll(" +", " ");
                try {
                    double result = Calculator.calculate(expression);
                    System.out.println(expression + " = " + df.format(result));
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Результат не определен.");
                }
                isWrongAnswer = false;
            } else {
                isWrongAnswer = true;
            }
            userAnswer = askToContinue(scanner, isWrongAnswer).toLowerCase();
        } while (!"no".equals(userAnswer));
        System.out.println("Завершение программы.");
        scanner.close();
    }

    private static String askToContinue(Scanner scanner, boolean isWrongAnswer) {
        System.out.print(!isWrongAnswer ? "Хотите продолжить вычисления? [yes/no]: " :
                "Введите корректный ответ [yes/no]: ");
        return scanner.nextLine();
    }
}