import java.util.Scanner;

public class Calculator {
    
    private int x;
    private int y;
    private char sign;
    private Scanner scanner = new Scanner(System.in);

    public int getX() {
        return x;
    }

    public void setX() {
        System.out.print("Введите первое число: ");
        this.x = scanner.nextInt();
    }

    public int getY() {
        return y;
    }

    public void setY() {
        System.out.print("Введите второе число: ");
        this.y = scanner.nextInt();
    }

    public char getSign() {
        return sign;
    }

    public void setSign() {
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
        this.sign = userInput.charAt(0);
    }

    public void calculate() {
        switch (sign) {
            case '+':
                System.out.println(x + y);
                break;
            case '-':
                System.out.println(x - y);
                break;
            case '*':
                System.out.println(x * y);
                break;
            case '/':
                if (y == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                } else {
                    System.out.println((double) x / y);
                }
                break;
            case '^': {
                double result = 1.0;
                if (y != 0) {
                    double xDouble;
                    if (y < 0) {
                        xDouble = 1.0 / x;
                        y = -y;    
                    } else {
                        xDouble = (double) x;
                    }
                    while (y-- > 0) {
                        result *= xDouble;
                    }
                }
                System.out.println(result);
                break;
            }
            case '%': {
                if (x < 0 || y < 0) {
                    System.out.println("Ошибка: операнды не должны быть отрицательными");
                    break;
                }
                if (y == 0) {
                    System.out.println("Ошибка: деление по модулю 0 запрещено");
                    break;
                }
                System.out.println(x % y);
            }
        }
    }
}