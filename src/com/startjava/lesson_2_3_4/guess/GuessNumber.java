package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    private final Player playerOne;
    private final Player playerTwo;

    public GuessNumber(String nameOne, String nameTwo) {
        this.playerOne = new Player(nameOne);
        this.playerTwo = new Player(nameTwo);
    } 

    public void play(Scanner scanner) {
        playerOne.clear();
        playerTwo.clear();
        System.out.println("\nИгра началась! У каждого игрока по 10 попыток.");
        int hiddenNumber = (int) (Math.random() * 100) + 1;
        Player currentPlayer = playerOne;
        System.out.println(); 
        do {
            input(currentPlayer, scanner);
            if (!isGuessed(currentPlayer.getNumber(), hiddenNumber)) {
                checkAttempts(currentPlayer);
                currentPlayer = change(currentPlayer);
            } else {
                break;
            }
        } while (playerTwo.getAttempt() < MAX_ATTEMPTS);
        printWinner(hiddenNumber);
        outputNumbers(playerOne);
        outputNumbers(playerTwo);
    }

    private void input(Player player, Scanner scanner) {
        System.out.print("Ход " + player.getName() + ": ");
        int guessNumber = scanner.nextInt();
        scanner.nextLine();
        player.addNumber(guessNumber);
    }

    private boolean isGuessed(int guessNumber, int hiddenNumber) {
        boolean isGuessed = hiddenNumber == guessNumber;
        if (!isGuessed) {
            System.out.println(guessNumber + (hiddenNumber > guessNumber ? " меньше" : " больше") +
                    " того, что загадал компьютер.");
        }
        return isGuessed;
    }

    private void checkAttempts(Player player) {
        if (player.getAttempt() == MAX_ATTEMPTS) {
            System.out.println("У " + player.getName() + " закончились попытки!");
        }
    }

    private Player change(Player currentPlayer) {
        return currentPlayer == playerOne ? playerTwo : playerOne;
    }

    private void printWinner(int hiddenNumber) {
        Player winner = null;
        if (playerOne.getNumber() == hiddenNumber) {
            winner = playerOne;
        } else if (playerTwo.getNumber() == hiddenNumber) {
            winner = playerTwo;
        }
        if (winner == null) {
            System.out.println("\nНикто не выиграл.");
        } else {
            System.out.println("\n" + winner.getName() + " угадал число с " +
                    winner.getAttempt() + "-й попытки.");
        }
    }

    private void outputNumbers(Player player) {
        System.out.println("\nЧисла " + player.getName() + ":");
        for (int number : player.getGuessNumbers()) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}