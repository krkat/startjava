package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static final int MAX_ATTEMPTS = 10;
    static final int LEFT_BOUND = 1;
    static final int RIGHT_BOUND = 100;
    static final int ROUNDS = 3;
    static final int NUMBER_PLAYERS = 3;

    private final Player[] players;

    public GuessNumber(String... names) {
        players = new Player[NUMBER_PLAYERS];
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            players[i] = new Player(names[i]);
        }
    }

    public void play(Scanner scanner) {
        for (Player player : players) {
            player.clearWins();
        }
        castLots();
        System.out.println("\nИгра началась! У каждого игрока в каждом раунде по " +
                MAX_ATTEMPTS + " попыток.");
        Random r = new Random();
        for (int i = 1; i <= ROUNDS; i++) {
            for (Player player : players) {
                player.clearAttempts();
            }
            int hiddenNumber = r.nextInt(LEFT_BOUND, RIGHT_BOUND + 1);
            int currentIndex = 0;
            Player currentPlayer = players[currentIndex];
            Player winner = null;
            System.out.println("\nРаунд " + i + "\n");
            do {
                inputNumber(currentPlayer, scanner);
                if (isGuessed(currentPlayer.getLastNumber(), hiddenNumber)) {
                    winner = currentPlayer;
                    winner.increaseWins();
                    break;
                }
                checkAttempts(currentPlayer);
                currentIndex = change(currentIndex);
                currentPlayer = players[currentIndex];
            } while (players[NUMBER_PLAYERS - 1].getAttempt() < MAX_ATTEMPTS);
            printRoundResults(winner);
        }
        printGameWinner();
    }

    private void castLots() {
        for (int i = NUMBER_PLAYERS - 1; i > 0; i--) {
            int index = (int) (Math.random() * i);
            if (index < i) {
                Player swap = players[i];
                players[i] = players[index];
                players[index] = swap;
            }
        }
        System.out.println("\nИгроки бросают жребий...");
        System.out.println("Порядок хода игроков:");
        for (Player player : players) {
            System.out.print(player.getName() + " ");
        }
        System.out.println();
    }

    private void inputNumber(Player player, Scanner scanner) {
        System.out.print("Ход " + player.getName() + ": ");
        int guessNumber = scanner.nextInt();
        scanner.nextLine();
        while (!player.addNumber(guessNumber)) {
            System.out.println("Число должно входить в интервал [" + LEFT_BOUND + ", " + RIGHT_BOUND + "].");
            System.out.print("Попробуйте еще раз: ");
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
        if (player.getAttempt() >= MAX_ATTEMPTS) {
            System.out.println("У " + player.getName() + " закончились попытки!");
        }
    }

    private int change(int currentIndex) {
        return currentIndex < players.length - 1 ? currentIndex + 1 : 0;
    }

    private void printRoundResults(Player winner) {
        if (winner == null) {
            System.out.println("\nНикто не выиграл.");
        } else {
            System.out.println("\n" + winner.getName() + " угадал число с " +
                    winner.getAttempt() + "-й попытки.");
        }
        System.out.println("Числа игроков:");
        for (Player player : players) {
            for (int number : player.getGuessNumbers()) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private void printGameWinner() {
        System.out.print("\nПо результатам " + ROUNDS + " раундов ");
        Arrays.sort(players, Comparator.comparingInt(Player::getWins).reversed());
        if (players[0].getWins() == 0) {
            System.out.println("никто не выиграл.");
            return;
        }
        int counterWinners = 0;
        Player[] winners = new Player[NUMBER_PLAYERS];
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            counterWinners++;
            winners[i] = players[i];
            if (i != NUMBER_PLAYERS - 1 && players[i].getWins() > players[i + 1].getWins()) {
                break;
            }
        }
        if (counterWinners == 1) {
            System.out.println("выиграл " + players[0].getName() + "!");
        } else {
            System.out.println(counterWinners + " игрока сыграли вничью:");
            for (Player player : Arrays.copyOf(winners, counterWinners)) {
                System.out.print(player.getName() + " ");
            }
            System.out.println();
        }
    }
}