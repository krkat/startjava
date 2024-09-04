package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    
    private final String name;
    private final int[] playerNumbers = new int[10];
    private int counterEfforts = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getPlayerNumbers() {
        return Arrays.copyOfRange(playerNumbers, 0, counterEfforts);
    }

    public int getCounterEfforts() {
        return counterEfforts;
    }

    public int getNumber() {
        return playerNumbers[counterEfforts - 1];
    }

    public void addNumber(int guessNumber) {
        playerNumbers[counterEfforts] = guessNumber;
        counterEfforts++;
    }

    public void clearPlayerNumbers() {
        Arrays.fill(playerNumbers, 0, counterEfforts, 0);
        counterEfforts = 0;
    }
}