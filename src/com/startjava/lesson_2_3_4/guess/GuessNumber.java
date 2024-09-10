package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    private Player[] players;
    private int currentIndex;

    public GuessNumber(String... names) {
        players = new Player[names.length];
        int i = 0;
        for (String name : names) {
            players[i++] = new Player(name);
        }
    }

    public void play(Scanner scanner) {
        for (Player player : players) {
            player.clear();
        }
        System.out.println("\nИгра началась! У каждого игрока по 10 попыток.");
        int hiddenNumber = (int) (Math.random() * 100) + 1;
        Player currentPlayer = players[currentIndex];
        System.out.println(); 
        do {
            input(currentPlayer, scanner);
            if (!isGuessed(currentPlayer.getNumber(), hiddenNumber)) {
                checkAttempts(currentPlayer);
                currentPlayer = change(currentPlayer);
            } else {
                break;
            }
        } while (players[players.length - 1].getAttempt() < MAX_ATTEMPTS);
        printWinner(hiddenNumber);
        for (Player player : players) {
            outputNumbers(player);
        }
    }

    private void input(Player player, Scanner scanner) {
        System.out.print("Ход " + player.getName() + ": ");
        int guessNumber = scanner.nextInt();
        scanner.nextLine();
        while (!player.addNumber(guessNumber)) {
            System.out.println("Число должно входить в интервал [1, 100].");
            System.out.print("Попробуйте еще раз:");
            guessNumber = scanner.nextInt();
            scanner.nextLine();
        }
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
        if (currentIndex == players.length - 1) {
            currentIndex = 0;
        } else {
            currentIndex++;
        }
        return players[currentIndex];
    }

    private void printWinner(int hiddenNumber) {
        Player winner = null;
        for (Player player : players) {
            if (player.getNumber() == hiddenNumber) {
                winner = player;
                break;
            }
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