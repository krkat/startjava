public class Calculator {    

    private int x;
    private int y;
    private char sign;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getSign() {
        return sign;
    }

    public boolean setSign(char sign) {
        if (sign != '+' && sign != '-' && sign != '*' && 
                sign != '/' && sign != '^' && sign != '%') {
            System.out.println("Ошибка: операция '" + sign + "' не поддерживается.");
            System.out.println("Доступны следующие операции: +. -, *. /, ^. %");
            return false;
        }
        this.sign = sign;
        return true;
    }

    public void calculate() {
        double result; 
        switch (sign) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '^':
                result = 1; 
                for (int i = 1; i <= (y >= 0 ? y : -y); i++) {
                    result *= x;
                }
                if (y < 0) {
                    result = 1 / result;
                }
                break;
            case '/':
            case '%':
                if (y == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return;
                } else {
                    result = sign == '/' ? (double) x / y : x % y;
                }
                break;
            default:
                System.out.println("Ошибка: операция не поддерживается.");
                return; 
        }
        System.out.println(result);       
    }
}