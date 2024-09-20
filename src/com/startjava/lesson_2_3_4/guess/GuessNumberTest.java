package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GuessNumber game = new GuessNumber(inputNames(scanner));

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

    private static String[] inputNames(Scanner scanner) {
        String[] namePlayers = new String[GuessNumber.NUMBER_PLAYERS];
        for (int i = 1; i <= GuessNumber.NUMBER_PLAYERS; i++) {
            askName(i, namePlayers, scanner);
        }
        return namePlayers;
    }

    private static void askName(int i, String[] namePlayers, Scanner scanner) {
        System.out.print("Введите имя " + i + " игрока: ");
        namePlayers[i - 1] = scanner.nextLine();
    }

    private static String askToContinue(Scanner scanner, boolean isWrongAnswer) {
        System.out.print(!isWrongAnswer ? "\nХотите продолжить игру? [yes/no]: " :
                "Введите корректный ответ [yes/no]: ");
        return scanner.nextLine();
    } 
}