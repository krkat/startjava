package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        String namePlayerOne = scanner.nextLine();
        System.out.print("Введите имя второго игрока: ");
        String namePlayerTwo = scanner.nextLine();
        Player playerOne = new Player(namePlayerOne);
        Player playerTwo = new Player(namePlayerTwo);
        GuessNumber game = new GuessNumber(playerOne, playerTwo);
        
        String playerAnswer;
        do {
            game.play(scanner);
            do {
                playerAnswer = askToContinue(scanner);
            } while (!"yes".equals(playerAnswer) && !"no".equals(playerAnswer)); 
        } while ("yes".equals(playerAnswer));
        System.out.println("Игра окончена.");
        scanner.close();
    }

    private static String askToContinue(Scanner scanner) {
        System.out.print("Хотите продолжить игру? [yes, no]: ");
        return scanner.nextLine();
    } 
}