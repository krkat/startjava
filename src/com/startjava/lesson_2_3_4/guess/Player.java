package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    
    private final String name;
    private final int[] guessNumbers = new int[10];
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

    public int getAttempt() {
        return attempt;
    }

    public int getNumber() {
        return guessNumbers[attempt - 1];
    }

    public void addNumber(int guessNumber) {
        guessNumbers[attempt] = guessNumber;
        attempt++;
    }

    public void clearPlayerNumbers() {
        Arrays.fill(guessNumbers, 0, attempt, 0);
        attempt = 0;
    }
}