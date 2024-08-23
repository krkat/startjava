package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    private static final DecimalFormat decimalFormat = new DecimalFormat("###.###");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator;
        String[] operandsAndSigns;
        String userAnswer;
        do {
            System.out.print("Введите математическое выражение: ");
            operandsAndSigns = scanner.nextLine().split(" ");
            calculator = new Calculator(operandsAndSigns);
            for (String s : operandsAndSigns) {
                System.out.print(s + " ");
            }
            System.out.print("= ");
            System.out.println(decimalFormat.format(calculator.calculate()));
            boolean isRepeat = false;
            do {
                userAnswer = askToContinue(scanner, isRepeat);
                isRepeat = true;
            } while (!"yes".equalsIgnoreCase(userAnswer) && !"no".equalsIgnoreCase(userAnswer));
        } while ("yes".equalsIgnoreCase(userAnswer));
        System.out.println("Завершение программы.");
        scanner.close();
    }

    private static String askToContinue(Scanner scanner, boolean isRepeat) {
        System.out.print(!isRepeat ? "Хотите продолжить вычисления? [yes/no]: " : "Введите корректный ответ [yes/no]: ");
        return scanner.nextLine();
    }
}