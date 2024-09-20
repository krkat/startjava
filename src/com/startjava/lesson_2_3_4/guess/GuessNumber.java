package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    public static final int LEFT_BOUND = 1;
    public static final int RIGHT_BOUND = 100;
    private static final int ROUNDS = 3;
    public static final int NUMBER_PLAYERS = 3;

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
            printRoundWinner(winner);
            printNumbers();
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

    private void printRoundWinner(Player winner) {
        if (winner == null) {
            System.out.println("\nНикто не выиграл.");
        } else {
            System.out.println("\n" + winner.getName() + " угадал число с " +
                    winner.getAttempt() + "-й попытки.");
        }
    }

    private void printNumbers() {
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
        int notWinners = 0;
        int counterTie = 0;
        Player winner = null;
        for (Player player : players) {
            if (player.getWins() >= 2) {
                System.out.println("выиграл " + player.getName() + "!");
                return;
            }
            if (player.getWins() == 1) {
                counterTie++;
                winner = player;
                continue;
            }
            if (player.getWins() == 0) {
                notWinners++;
            }
        }
        if (notWinners == 3) {
            System.out.println("никто не выиграл!");
            return;
        }
        if (counterTie == 1) {
            System.out.println("выиграл " + winner.getName() + "!");
            return;
        }
        if (counterTie >= 2) {
            System.out.println(counterTie + " игрока сыграли вничью.");
        }
    }
}