package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] guessNumbers = new int[GuessNumber.MAX_ATTEMPTS];
    private int attempt;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getGuessNumbers() {
        return Arrays.copyOf(guessNumbers, attempt);
    }

    public int getNumber() {
        return guessNumbers[attempt - 1];
    }

    public boolean addNumber(int guessNumber) {
        if (guessNumber < GuessNumber.LEFT_BOUND || guessNumber > GuessNumber.RIGHT_BOUND) {
            return false;
        }
        guessNumbers[attempt++] = guessNumber;
        return true;
    }

    public int getAttempt() {
        return attempt;
    }

    public void clear() {
        Arrays.fill(guessNumbers, 0, attempt, 0);
        attempt = 0;
    }
}