public class Calculator {
    public static void main(String[] args) {
        int firstOperand = 2;
        int secondOperand = 3;
        char sign = '%';
        int result = 0;
        if (sign == '+') {
            result = firstOperand + secondOperand;
        } else if (sign == '-') {
            result = firstOperand - secondOperand;
        } else if (sign == '*') {
            result = firstOperand * secondOperand;
        } else if (sign == '/') {
            result = firstOperand / secondOperand;
        } else if (sign == '^') {
            result = firstOperand;
            int counter = secondOperand - 1;
            while (counter >= 1) {
                result *= firstOperand;
                counter--;
            }
        } else if (sign == '%') {
            result = firstOperand % secondOperand;
        }
        System.out.printf("%d %c %d = %d", firstOperand, sign, secondOperand, result);
    }
}