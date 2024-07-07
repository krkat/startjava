import java.util.Scanner;

public class GuessNumber {
    
    private Player playerOne;
    private Player playerTwo;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    } 

    public void playGame(int hiddenNumber, Scanner scanner) {
        int guessNumber;
        Player currentPlayer = playerOne;
        System.out.println(); 
        do {
            System.out.print("Ход " + currentPlayer.getName() + ": ");
            guessNumber = scanner.nextInt();
            scanner.nextLine();
            currentPlayer.setNumber(guessNumber); 
            if (currentPlayer.equals(playerOne)) {
                currentPlayer = playerTwo;
            } else {
                currentPlayer = playerOne;
            }
        } while (hiddenNumber != guessNumber);
        printWinner(hiddenNumber);
    }

    private void printWinner(int hiddenNumber) {
        System.out.print("Победил ");
        if (playerOne.getNumber() == hiddenNumber) {
            System.out.println(playerOne.getName() + "!");
        }
        if (playerTwo.getNumber() == hiddenNumber) {
            System.out.println(playerTwo.getName() + "!");
        }
    }
}