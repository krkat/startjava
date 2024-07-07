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
        int guessNumber;
        Player currentPlayer = playerOne;
        boolean isWin = false;
        System.out.println(); 
        do {
            System.out.print("Ход " + currentPlayer.getName() + ": ");
            guessNumber = scanner.nextInt();
            scanner.nextLine();
            currentPlayer.setNumber(guessNumber); 

            isWin = hiddenNumber == guessNumber;
            if (!isWin) {
                String hint = hiddenNumber > guessNumber ? 
                        guessNumber + " меньше того, что загадал компьютер." : 
                        guessNumber + " больше того, что загадал компьютер.";
                System.out.println(hint);
            }
            currentPlayer = currentPlayer.equals(playerOne) ? playerTwo : playerOne;
        } while (!isWin);
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