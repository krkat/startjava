package com.startjava.lesson_2_3.guess;

import java.util.Scanner;

public class GuessNumber {
    
    private Player playerOne;
    private Player playerTwo;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    } 

    public void play(Scanner scanner) {
        int hiddenNumber = (int) (Math.random() * 100) + 1;
        Player currentPlayer = playerOne;
        System.out.println(); 
        do {
            System.out.print("Ход " + currentPlayer.getName() + ": ");
            if (!guessNumber(scanner, currentPlayer, hiddenNumber)) {
                checkNumber(hiddenNumber, currentPlayer.getNumber());
                currentPlayer = currentPlayer.equals(playerOne) ? playerTwo : playerOne;
            } else {
                break;
            }
        } while (true);
        printWinner(currentPlayer);
    }

    private boolean guessNumber(Scanner scanner, Player player, int hiddenNumber) {
        int guessNumber = scanner.nextInt();
        scanner.nextLine();
        player.setNumber(guessNumber);
        return hiddenNumber == guessNumber;
    }

    private void checkNumber(int hiddenNumber, int guessNumber) {
        System.out.println(guessNumber + (hiddenNumber > guessNumber ? " меньше" : " больше") + 
                " того, что загадал компьютер.");            
    }

    private void printWinner(Player winner) {
        System.out.println("Победил " + winner.getName() + "!");
    }
}