package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static final int NUMBER_PLAYERS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] namePlayers = new String[NUMBER_PLAYERS];
        for (int i = 1; i <= namePlayers.length; i++) {
            System.out.print("Введите имя " + i + " игрока: ");
            namePlayers[i - 1] = scanner.nextLine();
        }
        GuessNumber game = new GuessNumber(namePlayers);

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