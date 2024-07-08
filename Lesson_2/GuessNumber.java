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
        boolean isWin = false;
        System.out.println(); 
        do {
            System.out.print("Ход " + currentPlayer.getName() + ": ");
            int guessNumber = guessNumber(scanner, currentPlayer);
            isWin = hiddenNumber == guessNumber;
            if (!isWin) {
                checkNumber(hiddenNumber, guessNumber);
                currentPlayer = currentPlayer.equals(playerOne) ? playerTwo : playerOne;
            }
        } while (!isWin);
        printWinner(currentPlayer);
    }

    private int guessNumber(Scanner scanner, Player player) {
        int guessNumber = scanner.nextInt();
        scanner.nextLine();
        player.setNumber(guessNumber);
        return guessNumber;
    }

    private void checkNumber(int hiddenNumber, int guessNumber) {
        String hint = hiddenNumber > guessNumber ? " меньше" : " больше";
        System.out.println(guessNumber + hint + " того, что загадал компьютер.");            
    }

    private void printWinner(Player winner) {
        System.out.println("Победил " + winner.getName() + "!");
    }
}