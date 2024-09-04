package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private static final int NUMBER_EFFORTS = 10;
    private final Player playerOne;
    private final Player playerTwo;

    public GuessNumber(String nameOne, String nameTwo) {
        this.playerOne = new Player(nameOne);
        this.playerTwo = new Player(nameTwo);
    } 

    public void play(Scanner scanner) {
        playerOne.clearPlayerNumbers();
        playerTwo.clearPlayerNumbers();
        System.out.println("\nИгра началась! У каждого игрока по 10 попыток.");
        int hiddenNumber = (int) (Math.random() * 100) + 1;
        Player currentPlayer = playerOne;
        System.out.println(); 
        do {
            System.out.print("Ход " + currentPlayer.getName() + ": ");
            if (!guessNumber(scanner, currentPlayer, hiddenNumber)) {
                checkNumber(hiddenNumber, currentPlayer.getNumber());
                if (currentPlayer.getCounterEfforts() == 10) {
                    System.out.println("У " + currentPlayer.getName() + " закончились попытки!");
                }
                currentPlayer = currentPlayer.equals(playerOne) ? playerTwo : playerOne;
            } else {
                break;
            }
        } while (playerOne.getCounterEfforts() < NUMBER_EFFORTS ||
                playerTwo.getCounterEfforts() < NUMBER_EFFORTS);
        Player winner = null;
        if (playerOne.getNumber() == hiddenNumber) {
            winner = playerOne;
        } else if (playerTwo.getNumber() == hiddenNumber) {
            winner = playerTwo;
        }
        printWinner(winner);
        outputNumbers(playerOne);
        outputNumbers(playerTwo);
    }

    private boolean guessNumber(Scanner scanner, Player player, int hiddenNumber) {
        int guessNumber = scanner.nextInt();
        scanner.nextLine();
        player.addNumber(guessNumber);
        return hiddenNumber == guessNumber;
    }

    private void checkNumber(int hiddenNumber, int guessNumber) {
        System.out.println(guessNumber + (hiddenNumber > guessNumber ? " меньше" : " больше") + 
                " того, что загадал компьютер.");            
    }

    private void printWinner(Player winner) {
        if (winner == null) {
            System.out.println("\nНикто не выиграл.");
        } else {
            System.out.println("\n" + winner.getName() + " угадал число с " +
                    winner.getCounterEfforts() + "-й попытки.");
        }
    }

    private void outputNumbers(Player player) {
        System.out.println("\nЧисла " + player.getName() + ":");
        for (int number : player.getPlayerNumbers()) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}