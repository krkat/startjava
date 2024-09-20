package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] guessNumbers = new int[GuessNumber.MAX_ATTEMPTS];
    private int attempt;
    private int wins;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAttempt() {
        return attempt;
    }

    public int getWins() {
        return wins;
    }

    public int[] getGuessNumbers() {
        return Arrays.copyOf(guessNumbers, attempt);
    }

    public int getLastNumber() {
        return guessNumbers[attempt - 1];
    }

    public boolean addNumber(int guessNumber) {
        if (guessNumber < GuessNumber.LEFT_BOUND || guessNumber > GuessNumber.RIGHT_BOUND) {
            return false;
        }
        guessNumbers[attempt++] = guessNumber;
        return true;
    }

    public void increaseWins() {
        wins++;
    }

    public void clearAttempts() {
        Arrays.fill(guessNumbers, 0, attempt, 0);
        attempt = 0;
    }

    public void clearWins() {
        wins = 0;
    }
}