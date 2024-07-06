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

            String userInput;
            do {
                System.out.print("Введите знак операции (+. -, *. /, ^. %)): ");
                userInput = scanner.next();
                if (!"+".equals(userInput) && !"-".equals(userInput) && 
                        !"*".equals(userInput) && !"/".equals(userInput) && 
                        !"^".equals(userInput) && !"%".equals(userInput)) {
                    System.out.println("Ошибка: операция '" + userInput + "' не поддерживается.");
                    System.out.println("Доступны следующие операции: +. -, *. /, ^. %");
                }
            } while (!"+".equals(userInput) && !"-".equals(userInput) && 
                     !"*".equals(userInput) && !"/".equals(userInput) && 
                     !"^".equals(userInput) && !"%".equals(userInput));
            char sign = userInput.charAt(0);
            calculator.setSign(sign);

            System.out.print("Введите второе число: ");
            int y = scanner.nextInt();
            calculator.setY(y);
            
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