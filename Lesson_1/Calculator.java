public class Calculator {
    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        char sign = '^';
        int result = 0;
        if (sign == '+') {
            result = x + y;
        } else if (sign == '-') {
            result = x - y;
        } else if (sign == '*') {
            result = x * y;
        } else if (sign == '/') {
            result = x / y;
        } else if (sign == '^') {
            result = x;
            for (int i = y - 1; i >= 1; i--) {
                result *= x;
            }
        } else if (sign == '%') {
            result = x % y;
        }
        System.out.printf("%d %c %d = %d", x, sign, y, result);
    }
}