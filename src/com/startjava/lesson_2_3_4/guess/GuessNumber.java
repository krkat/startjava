package com.startjava.lesson_2_3_4.guess;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    public static final int LEFT_BOUND = 1;
    public static final int RIGHT_BOUND = 100;
    private static final int ROUNDS = 3;

    private final Player[] players;
    private final Map<Player, Integer> winners = new HashMap<>();

    public GuessNumber(String... names) {
        players = new Player[names.length];
        int i = 0;
        for (String name : names) {
            players[i++] = new Player(name);
        }
    }

    public void play(Scanner scanner) {
        winners.clear();
        castLots();
        System.out.println("\nИгра началась! У каждого игрока в каждом раунде по " +
                MAX_ATTEMPTS + " попыток.");
        Random r = new Random();
        for (int i = 1; i <= ROUNDS; i++) {
            System.out.println("\nРаунд " + i);
            for (Player player : players) {
                player.clear();
            }
            int hiddenNumber = r.nextInt(LEFT_BOUND, RIGHT_BOUND);
            int currentIndex = 0;
            Player currentPlayer = players[currentIndex];
            System.out.println();
            do {
                inputNumber(currentPlayer, scanner);
                if (isGuessed(currentPlayer.getNumber(), hiddenNumber)) {
                    break;
                }
                checkAttempts(currentPlayer);
                currentIndex = change(currentIndex);
                currentPlayer = players[currentIndex];
            } while (players[players.length - 1].getAttempt() < MAX_ATTEMPTS);
            printWinner(hiddenNumber);
            System.out.println("Числа игроков:");
            for (Player player : players) {
                printNumbers(player);
            }
        }
        printRoundWinner();
    }

    private void castLots() {
        for (int i = players.length - 1; i > 0; i--) {
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
        if (player.getAttempt() == MAX_ATTEMPTS) {
            System.out.println("У " + player.getName() + " закончились попытки!");
        }
    }

    private int change(int currentIndex) {
        return currentIndex < players.length - 1 ? currentIndex + 1 : 0;
    }

    private void printWinner(int hiddenNumber) {
        Player winner = null;
        for (Player player : players) {
            if (player.getNumber() == hiddenNumber) {
                winner = player;
                winners.merge(winner, 1, (a, b) -> b + 1);
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

    private void printNumbers(Player player) {
        for (int number : player.getGuessNumbers()) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private void printRoundWinner() {
        System.out.print("\nПо результатам " + ROUNDS + " раундов ");
        if (winners.keySet().isEmpty()) {
            System.out.println("никто не выиграл!");
            return;
        }
        int counterTie = 0;
        Player winnerInOneRound = null;
        for (Player player : winners.keySet()) {
            Integer playerScore = winners.get(player);
            if (playerScore < 2) {
                counterTie++;
                winnerInOneRound = player;
            } else {
                System.out.println("выиграл " + player.getName() + "!");
                return;
            }
        }
        if (counterTie > 1) {
            System.out.println(counterTie + " игрока сыграли вничью.");
        } else {
            System.out.println("выиграл " + winnerInOneRound.getName() + "!");
        }
    }
}