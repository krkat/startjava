package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        String nameOne = scanner.nextLine();
        System.out.print("Введите имя второго игрока: ");
        String nameTwo = scanner.nextLine();
        System.out.print("Введите имя третьего игрока: ");
        String nameThree = scanner.nextLine();

        GuessNumber game = new GuessNumber(nameOne, nameTwo, nameThree);

        String playerAnswer = "yes";
        boolean isWrongAnswer;
        do {
            if ("yes".equals(playerAnswer)) {
                game.play(scanner);
                isWrongAnswer = false;
            } else {
                isWrongAnswer = true;
            }
            playerAnswer = askToContinue(scanner, isWrongAnswer).toLowerCase();
        } while (!"no".equals(playerAnswer));
        System.out.println("Игра окончена.");
        scanner.close();
    }

    private static String askToContinue(Scanner scanner, boolean isWrongAnswer) {
        System.out.print(!isWrongAnswer ? "\nХотите продолжить игру? [yes/no]: " :
                "Введите корректный ответ [yes/no]: ");
        return scanner.nextLine();
    } 
}