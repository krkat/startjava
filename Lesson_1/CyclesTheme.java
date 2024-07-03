public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел");
        int startPoint = -10;
        int endPoint = 21;
        int sumOfEvens = 0;
        int sumOfOdds = 0;
        for (int i = startPoint; i <= endPoint; i++) {
            if (i % 2 == 0) {
                sumOfEvens += i;
            } else {
                sumOfOdds += i;
            }
        }
        System.out.println("В отрезке [" + startPoint + ", " + endPoint + 
                "] сумма четных чисел = " + sumOfEvens + ", а нечетных = " + sumOfOdds);

        System.out.println("\n2. Вывод чисел между min и max в порядке убывания");
        int a = 10;
        int b = 5;
        int c = -1;
        int min = a;
        int max = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        if (b > max) {
            max = b;    
        }
        if (c > max) {
            max = c;
        }
        for (int i = max - 1; i > min; i--) {
            System.out.printf("%4d", i);
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        int originNumber = 1234;
        int sumOfDigits = 0;
        System.out.print("Исходное число в обратном порядке поразрядно: ");
        int module = 10;
        int leftSide = originNumber;
        do {
            int digit = leftSide % module;
            leftSide /= module;
            sumOfDigits += digit;
            System.out.print(digit);
        } while (leftSide > 0);
        System.out.println("\nСумма цифр = " + sumOfDigits);

        System.out.println("\n4. Вывод чисел в несколько строк");
        int numbersInLine = 0;
        for (int i = 1; i < 24; i += 2) {
            numbersInLine++;
            System.out.printf("%4d", i);
            if (numbersInLine == 5) {
                System.out.println();
                numbersInLine = 0;
            }
        }
        int zeros = 5 - numbersInLine % 5;
        if (zeros != 0 && zeros != 5) {
            for (int i = 1; i <= zeros; i++) {
                System.out.printf("%4d", 0);
            }
        }

        System.out.println("\n\n5. Проверка количества двоек числа на четность");
        originNumber = 3242592;
        int sumOfTwos = 0;
        module = 10;
        leftSide = originNumber;
        do {
            if (leftSide % module == 2) {
                sumOfTwos++;
            }
            leftSide /= module;
        } while (leftSide > 0);
        System.out.print("В " + originNumber);
        if (sumOfTwos % 2 == 0) {
            System.out.print(" четное ");
        } else {
            System.out.print(" нечетное ");
        }
        System.out.println("(" + sumOfTwos + ") количество двоек");

        System.out.println("\n6. Вывод геометрических фигур");
        int numberLines = 5;

        // Вывод прямоугольника
        for (int i = 0; i < numberLines; i++) {
            System.out.println("**********");
        }
        System.out.println();
        
        // Вывод прямоугольного треугольника
        while (numberLines > 0) {
            int countSymbols = numberLines;
            while (countSymbols > 0) {
                System.out.print("#");
                countSymbols--;
            }
            System.out.println();
            numberLines--;
        }
        System.out.println();
        
        // Вывод равнобедренного треугольника
        numberLines = 1;
        int counterSymbols = 0;
        do {
            if (numberLines <= 3) {
                counterSymbols++;
            } else {
                counterSymbols--;
            }
            int counterCycle = counterSymbols;
            do {
                System.out.print("$");
                counterCycle--;
            } while (counterCycle > 0);
            System.out.println();
            numberLines++;
        } while (numberLines < 6);

        System.out.println("\n7. Вывод ASCII-символов");
        System.out.println("DECIMAL CHARACTER DESCRIPTION");
        for (char i = 33; i < '0'; i += 2) {
            System.out.printf("  %-3d       %c          %-20s%n", (int) i, i, Character.getName(i));
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (i % 2 == 0) {
                System.out.printf("  %-3d       %c          %-20s%n", (int) i, i, Character.getName(i));
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");
        originNumber = 1234321;
        int leftHalfOrigin = originNumber / 1000;
        int rightHalfOrigin = originNumber % 10000;
        int reverseLeftHalfOrigin = 0;
        module = 10;
        int multiplier = 1000;
        do {
            int digit = leftHalfOrigin % 10;
            leftHalfOrigin /= module;
            reverseLeftHalfOrigin += digit * multiplier;
            multiplier /= module;
        } while (leftHalfOrigin > 0);    
        System.out.printf("Число %d", originNumber);
        if (reverseLeftHalfOrigin != rightHalfOrigin) {
            System.out.print(" не палиндром\n");
        } else {
            System.out.print(" - палиндром\n");
        }

        System.out.println("\n9. Проверка, является ли число счастливым");
        originNumber = 123321;
        leftHalfOrigin = originNumber / 1000;
        rightHalfOrigin = originNumber % 1000;
        int sumLeftHalf = 0;
        int sumRightHalf = 0;
        module = 10;
        do {
            sumLeftHalf += leftHalfOrigin % module;
            leftHalfOrigin /= module; 
            sumRightHalf += rightHalfOrigin % module;
            rightHalfOrigin /= module;
        } while (leftHalfOrigin > 0);    
        System.out.printf("Число %d -", originNumber);
        if (sumLeftHalf == sumRightHalf) {
            System.out.print(" счастливое ");
        } else {
            System.out.print(" несчастливое ");
        }
        System.out.printf("\nСумма цифр " + leftHalfOrigin + " = %d", sumLeftHalf);
        System.out.printf("\nСумма цифр " + rightHalfOrigin + " = %d%n", sumRightHalf);

        System.out.println("\n10. Вывод таблицы умножения Пифагора");
        for (int i = 1; i <= 9; i++) {
            if (i == 1) {
                System.out.print("   |");
                for (int j = 2; j <= 9; j++) {
                    System.out.printf("%3d", j);    
                }
                System.out.print("\n___|");
                for (int j = 2; j <= 9; j++) {
                    System.out.print("___");
                }
                System.out.print("\n   |");
            } else {
                System.out.printf("%2d |", i);
                for (int j = 2; j <= 9; j++) {  
                    System.out.printf("%3d", i * j);    
                }
            }
            System.out.println();
        }
    }
}