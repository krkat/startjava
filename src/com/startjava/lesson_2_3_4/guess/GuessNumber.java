package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    public static final int LEFT_BOUND = 1;
    public static final int RIGHT_BOUND = 100;
    private static final int ROUNDS = 3;

    private final Player[] players;
    private int[] winners;

    public GuessNumber(String... names) {
        players = new Player[names.length];
        for (int i = 0; i < names.length; i++) {
            players[i] = new Player(names[i]);
        }
        winners = new int[players.length];
    }

    public void play(Scanner scanner) {
        winners = new int[players.length];
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
        for (int i = 0; i < players.length; i++) {
            if (players[i].getNumber() == hiddenNumber) {
                winner = players[i];
                winners[i]++;
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
        int notWinners = 0;
        int counterTie = 0;
        int indexWinner = 0;
        for (int i = 0; i < winners.length; i++) {
            if (winners[i] >= 2) {
                System.out.println("выиграл " + players[i].getName() + "!");
                return;
            }
            if (winners[i] == 1) {
                counterTie++;
                indexWinner = i;
            }
            if (winners[i] == 0) {
                notWinners++;
            }
        }
        if (notWinners == 3) {
            System.out.println("никто не выиграл!");
            return;
        }
        if (counterTie == 1) {
            System.out.println("выиграл " + players[indexWinner].getName() + "!");
        }
        if (counterTie >= 2) {
            System.out.println(counterTie + " игрока сыграли вничью.");
        }
    }
}