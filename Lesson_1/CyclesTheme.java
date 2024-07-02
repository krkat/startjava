public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел");
        int number = -10;
        int sumOfEvens = 0;
        int sumOfOdds = 0;
        do {
            if (number % 2 == 0) {
                sumOfEvens += number;
            } else {
                sumOfOdds += number;
            }
            number++;
        } while (number <= 21);
        System.out.println("В отрезке [-10, 21] сумма четных чисел = " + 
                sumOfEvens + ", а нечетных = " + sumOfOdds);

        System.out.println("\n2. Вывод чисел между min и max в порядке убывания");
        int[] array = new int[]{10, 5, -1};
        int min = array[0];
        int max = array[0];     
        for (int i = 0; i < 3; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.print("Т.к. чисел 3, из них 2 - min и max, то вывод чисел в порядке убывания");
        System.out.println(" из интервала, в котором 3 числа, теряет смысл.");
        for (int i = 0; i < 3; i++) {
            if (array[i] != min && array[i] != max) {
                System.out.printf("%4d", array[i]);
            }
        }
        System.out.println();

        System.out.println("\n3. Вывод реверсивного числа и суммы его цифр");
        int originNumber = 1234;
        int sumOfDigits = 0;
        int digit;
        int counterDigits = 1;
        System.out.print("_сходное число в обратном порядке поразрядно:");
        while (counterDigits < 5) {
            int a = 1;
            for (int i = 0; i < counterDigits; i++) {
                a *= 10;
            }
            int b = a / 10;
            digit = (originNumber % a - originNumber % b) / b;
            sumOfDigits += digit;
            System.out.printf("%2d", digit);
            counterDigits++;
        }
        System.out.println("\nСумма цифр = " + sumOfDigits);

        System.out.println("\n4. Вывод чисел в несколько строк");
        int numberOfOdds = 0;
        int numbersInString = 0;
        for (int i = 1; i < 24; i++) {
            if (i % 2 == 1) {
                numbersInString++;
                numberOfOdds++;
                System.out.printf("%4d", i);
                if (numbersInString == 5) {
                    System.out.println();
                    numbersInString = 0;
                }
            }
        }
        int zeros = 5 - numberOfOdds % 5;
        if (zeros != 0 && zeros != 5) {
            for (int i = 1; i <= zeros; i++) {
                System.out.printf("%4d", 0);
            }
        }
        System.out.println();

        System.out.println("\n5. Проверка количества двоек числа на четность");
        int someNumber = 3242592;
        int sumOfTwos = 0;
        int oneDigit;
        int counterOfDigits = 7;
        while (counterOfDigits > 0) {
            int a = 1;
            for (int i = 0; i < counterOfDigits; i++) {
                a *= 10;
            }
            int b = a / 10;
            oneDigit = (someNumber % a - someNumber % b) / b;
            if (oneDigit == 2) {
                sumOfTwos++;
            }
            counterOfDigits--;
        }
        System.out.print("В " + someNumber);
        if (sumOfTwos % 2 == 0) {
            System.out.print(" четное ");
        } else {
            System.out.print(" нечетное ");
        }
        System.out.println("(" + sumOfTwos + ") количество двоек");

        System.out.println("\n6. Вывод геометрических фигур");
        int numberStrings = 5;
        for (int i = 0; i < numberStrings; i++) {
            System.out.println("**********");
        }
        System.out.println();
        while (numberStrings > 0) {
            for (int i = 0; i < numberStrings; i++) {
                System.out.print("#");      
            }
            System.out.println();
            numberStrings--;
        }
        System.out.println();
        numberStrings = 1;
        int counterSymbols = 0;
        while (numberStrings < 6) {
            if (numberStrings <= 3) {
                counterSymbols++;
                for (int i = 0; i < counterSymbols; i++) {
                    System.out.print("$");
                }
                System.out.println();
            } else {
                counterSymbols--;
                for (int i = 0; i < counterSymbols; i++) {
                    System.out.print("$");
                }
                System.out.println();
            }
            numberStrings++;
        }

        System.out.println("\n7. Вывод ASCII-символов");
        System.out.println("DECIMAL CHARACTER DESCRIPTION");
        for (int i = 0; i <= 255; i++) {
            char symbol = (char) i;
            System.out.printf("%3d %3c %40s%n", i, symbol, Character.getName(i));
        } 

        System.out.println("\n8. Проверка, является ли число палиндромом");
        int checkedForPalindrome = 1234321;
        int digitFromLeft;
        int digitFromRight;
        int digits = 7;
        boolean isPalindrome = true;
        for (int i = 1; i <= 4; i++) {
            int a = 1;
            for (int j = 0; j < i; j++) {
                a *= 10;
            }
            int b = a / 10;
            digitFromLeft = (checkedForPalindrome % a - checkedForPalindrome % b) / b;
            int c = 1;
            for (int j = 0; j < digits - i + 1; j++) {
                c *= 10;
            }
            int d = c / 10;
            digitFromRight = (checkedForPalindrome % c - checkedForPalindrome % d) / d;
            if (digitFromLeft != digitFromRight) {
                isPalindrome = false;
                break;
            }
        }
        System.out.printf("Число %d", checkedForPalindrome);
        if (!isPalindrome) {
            System.out.print(" не палиндром\n");
        } else {
            System.out.print(" - палиндром\n");
        }

        System.out.println("\n9. Проверка, является ли число счастливым");
        int happyNumber = 123321;
        int happyDigit;
        int sumFirstHalf = 0;
        int sumSecondHalf = 0;
        for (int i = 1; i < 7; i++) {
            int a = 1;
            for (int j = 1; j <= i; j++) {
                a *= 10;
            }
            int b = a / 10;
            happyDigit = (happyNumber % a - happyNumber % b) / b;
            if (i < 4) {
                sumSecondHalf += happyDigit;
            } else {
                sumFirstHalf += happyDigit;
            }
        }
        System.out.printf("Число %d -", happyNumber);
        if (sumFirstHalf == sumSecondHalf) {
            System.out.print(" счастливое ");
        } else {
            System.out.print(" несчастливое ");
        }
        int firstHalf = (happyNumber - happyNumber % 1000) / 1000;
        int secondHalf = happyNumber % 1000;
        System.out.printf("\nСумма цифр " + firstHalf + " = %d", sumFirstHalf);
        System.out.printf("\nСумма цифр " + secondHalf + " = %d%n", sumSecondHalf);

        System.out.println("\n10. Вывод таблицы умножения Пифагора");
        for (int i = 1; i <= 9; i++) {
            if (i == 1) {
                System.out.print("   |");
                for (int j = 2; j <= 9; j++) {
                    System.out.printf("%3d", j);    
                }
                System.out.print("\n___|");
                for (int l = 2; l <= 9; l++) {
                    System.out.print("___");
                }
                System.out.print("\n   |");
            } else {
                System.out.printf("%2d ", i);
                System.out.print("|");
                for (int j = 2; j <= 9; j++) {  
                    System.out.printf("%3d", i * j);    
                }
            }
            System.out.println();
        }
    }
}