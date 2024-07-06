import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userAnswer;
        do {
            Calculator calculator = new Calculator();
            System.out.print("Введите первое число: ");
            int x = scanner.nextInt();
            calculator.setX(x);
            scanner.nextLine();

            char sign;
            boolean isCorrectSign = false;
            do {
                System.out.print("Введите знак операции (+. -, *. /, ^. %)): ");
                sign = scanner.nextLine().charAt(0);
                isCorrectSign = calculator.setSign(sign);
            } while (!isCorrectSign);
            
            System.out.print("Введите второе число: ");
            int y = scanner.nextInt();
            calculator.setY(y);
            scanner.nextLine();
            
            System.out.printf("%d %c %d = ", x, sign, y);
            calculator.calculate();
            do {
                userAnswer = askToContinue(scanner);
            } while (!"yes".equals(userAnswer) && !"no".equals(userAnswer));
            if ("no".equals(userAnswer)) {
                System.out.println("Завершение программы.");
                scanner.close();
                break;
            }
        } while ("yes".equals(userAnswer));
        scanner.close();
    }

    private static String askToContinue(Scanner scanner) {
        System.out.print("Хотите продолжить вычисления? [yes/no]: ");
        return scanner.nextLine();
    }
}