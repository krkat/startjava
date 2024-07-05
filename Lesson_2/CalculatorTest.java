import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        String userAnswer;
        do {
            Calculator calculator = new Calculator();
            calculator.setX();
            calculator.setSign();
            calculator.setY();
            System.out.print(calculator.getX() + " " + calculator.getSign() + 
                    " " + calculator.getY() + " = ");
            calculator.calculate();
            userAnswer = askToContinue();
        } while ("yes".equals(userAnswer));
    }

    private static String askToContinue() {
        System.out.print("Хотите продолжить вычисления? [yes/no]: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();
        return userAnswer;    
    }
}