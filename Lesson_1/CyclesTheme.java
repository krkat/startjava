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
        int digit;
        System.out.print("Исходное число в обратном порядке поразрядно: ");
        int module = 10;
        int divider = module / 10;
        do {
            int restForModule = originNumber % module;
            digit = restForModule / divider;
            sumOfDigits += digit;
            System.out.print(digit);
            if (restForModule == originNumber) {
                break;
            }
            module *= 10;
            divider = module / 10;
        } while (true);
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
        divider = module / 10;
        do {
            int restForModule = originNumber % module;
            digit = restForModule / divider;
            if (digit == 2) {
                sumOfTwos++;
            }
            if (restForModule == originNumber) {
                break;
            }
            module *= 10;
            divider = module / 10;
        } while (true);
        System.out.print("В " + originNumber);
        if (sumOfTwos % 2 == 0) {
            System.out.print(" четное ");
        } else {
            System.out.print(" нечетное ");
        }
        System.out.println("(" + sumOfTwos + ") количество двоек");

        System.out.println("\n6. Вывод геометрических фигур");
        int numberLines = 5;
        for (int i = 0; i < numberLines; i++) {
            System.out.println("**********");
        }
        System.out.println();
        while (numberLines > 0) {
            for (int i = 0; i < numberLines; i++) {
                System.out.print("#");      
            }
            System.out.println();
            numberLines--;
        }
        System.out.println();
        numberLines = 1;
        int counterSymbols = 0;
        while (numberLines < 6) {
            if (numberLines <= 3) {
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
            numberLines++;
        }

        System.out.println("\n7. Вывод ASCII-символов");
        System.out.println("DECIMAL CHARACTER DESCRIPTION");
        for (int i = 0; i <= 255; i++) {
            char symbol = (char) i;
            System.out.printf("%3d %3c %40s%n", i, symbol, Character.getName(i));
        } 

        System.out.println("\n8. Проверка, является ли число палиндромом");
        originNumber = 1234321;
        int leftHalfOrigin = originNumber / 1000;
        int rightHalfOrigin = originNumber % 10000;
        int reverseLeftHalfOrigin = 0;
        module = 10;
        divider = module / 10;
        int multiplier = 10000;
        do {
            int restForModule = leftHalfOrigin % module;
            digit = restForModule / divider;
            reverseLeftHalfOrigin += digit * multiplier / module;
            if (restForModule == leftHalfOrigin) {
                break;
            }
            module *= 10;
            divider = module / 10;
        } while (true);    
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
        divider = module / 10;
        multiplier = 10000;
        do {
            digit = leftHalfOrigin % module / divider;
            sumLeftHalf += digit;
            digit = rightHalfOrigin % module / divider;
            sumRightHalf += digit;
            module *= 10;
            divider = module / 10;
        } while (module < 10000);    
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