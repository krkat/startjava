import java.lang.Math;
import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        String namePlayerOne = scanner.nextLine();
        System.out.print("Введите имя второго игрока: ");
        String namePlayerTwo = scanner.nextLine();
        Player playerOne = new Player(namePlayerOne);
        Player playerTwo = new Player(namePlayerTwo);
        GuessNumber game = new GuessNumber(playerOne, playerTwo);
        
        String userAnswer;
        do {
            int hiddenNumber = (int) (Math.random() * 100) + 1;
            game.playGame(hiddenNumber, scanner);
            do {
                userAnswer = askToContinue(scanner);
            } while (!"yes".equals(userAnswer) && !"no".equals(userAnswer)); 
            if ("no".equals(userAnswer)) {
                break;
            }
        } while ("yes".equals(userAnswer));
        System.out.println("Игра окончена.");
        scanner.close();
    }

    private static String askToContinue(Scanner scanner) {
        System.out.print("Хотите продолжить игру? [yes, no]: ");
        return scanner.nextLine();
    } 
}