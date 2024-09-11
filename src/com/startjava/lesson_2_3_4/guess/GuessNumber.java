package com.startjava.lesson_2_3_4.guess;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
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
        System.out.println("\nИгра началась! У каждого игрока в каждом раунде по 10 попыток.");
        int round = 1;
        while (round <= 3) {
            System.out.println("\nРаунд " + round);
            for (Player player : players) {
                player.clear();
            }
            int hiddenNumber = (int) (Math.random() * 100) + 1;
            int currentIndex = 0;
            Player currentPlayer = players[currentIndex];
            System.out.println();
            do {
                input(currentPlayer, scanner);
                if (!isGuessed(currentPlayer.getNumber(), hiddenNumber)) {
                    checkAttempts(currentPlayer);
                    currentIndex = change(currentIndex);
                    currentPlayer = players[currentIndex];
                } else {
                    break;
                }
            } while (players[players.length - 1].getAttempt() < MAX_ATTEMPTS);
            printWinner(hiddenNumber);
            System.out.println("Числа игрококов:");
            for (Player player : players) {
                outputNumbers(player);
            }
            round++;
        }
        printRoundWinner();
    }

    private void castLots() {
        int n = players.length - 1;
        while (n > 0) {
            int index = (int) (Math.random() * n);
            if (index < n) {
                Player swap = players[n];
                players[n] = players[index];
                players[index] = swap;
            }
            n--;
        }
        System.out.println("\nИгроки бросают жребий...");
        System.out.println("Порядок хода игроков:");
        for (Player player : players) {
            System.out.print(player.getName() + " ");
        }
        System.out.println();
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

    private void outputNumbers(Player player) {
        for (int number : player.getGuessNumbers()) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private void printRoundWinner() {
        System.out.print("\nПо результатам трех раундов ");
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