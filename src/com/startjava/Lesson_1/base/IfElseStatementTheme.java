package com.startjava.lesson_1.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");
        boolean isMale = true;
        System.out.print("Если isMale = " + isMale + ", значит пол");
        if (!isMale) {
            System.out.println(" женский.");
        } else {
            System.out.println(" мужской.");
        }
        int humanAge = 15;
        System.out.print("Если age = " + humanAge + ", значит возраст ");
        if (humanAge > 18) {
            System.out.println("больше 18 лет.");
        } else {
            System.out.println("меньше или равен 18 годам.");
        }
        double humanHeight = 1.8;
        System.out.print("Если height = " + humanHeight + ", значит рост ");
        if (humanHeight < 1.8) {
            System.out.println("меньше 1,8 м.");
        } else {
            System.out.println("1,8 м или больше.");
        }
        String humanName = "Peter";
        char firstLetterOfName = humanName.charAt(0);
        System.out.print("Первая буква имени " + humanName);
        if (firstLetterOfName == 'M') {
            System.out.println(" - M.");
        } else if (firstLetterOfName == 'I') {
            System.out.println(" - I.");
        } else {
            System.out.println(" не M и не I.");
        }

        System.out.println("\n2. Поиск большего числа");
        int a = 242334;
        int b = -99;
        if (a > b) {
            System.out.println(a + " > " + b);
        } else if (a < b) {
            System.out.println(a + " < " + b);
        } else {
            System.out.println(a + " = " + b);
        }

        System.out.println("\n3. Проверка числа");
        int number = 14567;
        System.out.print(number + " является ");
        if (number == 0) {
            System.out.println("нулем.");
        } else {
            if (number > 0) {
                System.out.print("положительным и ");
            } else {
                System.out.print("отрицательным и ");
            }
            if (number % 2 == 0) {
                System.out.print("четным.");
            } else {
                System.out.println("нечетным.");
            }
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах");
        int firstInt = 123;
        int secondInt = 223;

        int onesFirstInt = firstInt % 10;
        int onesSecondInt = secondInt % 10;
        int tensFirstInt = firstInt % 100 / 10;
        int tensSecondInt = secondInt % 100 / 10;
        int hundredsFirstInt = firstInt % 1000 / 100;
        int hundredsSecondInt = secondInt % 1000 / 100;
        
        if (onesFirstInt != onesSecondInt && 
                tensFirstInt != tensSecondInt &&
                hundredsFirstInt != hundredsSecondInt) {
            System.out.println("Равных цифр нет.");
        } else {
            System.out.println("Исходные числа: " + firstInt + " и " + secondInt);
            if (onesFirstInt == onesSecondInt) {
                System.out.println("Одинаковые цифры: " + onesFirstInt + " в разряде 1.");
            }
            if (tensFirstInt == tensSecondInt) {
                System.out.println("Одинаковые цифры: " + tensFirstInt + " в разряде 2.");
            }
            if (hundredsFirstInt == hundredsSecondInt) {
                System.out.println("Одинаковые цифры: " + hundredsFirstInt + " в разряде 3.");
            }
        }

        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';
        System.out.print("'" + symbol + "'");
        if (symbol >= '0' && symbol <= '9') {
            System.out.println(" - цифра.");
        } else if (symbol >= 'A' && symbol <= 'Z') {
            System.out.println(" - большая буква.");
        } else if (symbol >= 'a' && symbol <= 'z') {
            System.out.println(" - маленькая буква.");
        } else {
            System.out.println(" - не буква и не цифра.");
        }

        System.out.println("\n6. Подсчет начисленных банком %");
        double deposit = 321123.59;
        int rate = 5;
        if (deposit >= 100000 && deposit <= 300000) {
            rate = 7;
        } else if (deposit > 300000) {
            rate = 10;
        }
        double interest = deposit * rate / 100;
        double changedDeposit = deposit + interest;
        System.out.println("Сумма вклада: " + deposit);
        System.out.println("Сумма начисленного %: " + interest);
        System.out.println("Итоговая сумма с %: " + changedDeposit);

        System.out.println("\n7. Определение оценки по предметам");
        int percentMarkForHistory = 59;
        int percentMarkForProgramming = 92;
        int markForHistory = toMark(percentMarkForHistory);
        int markForProgramming = toMark(percentMarkForProgramming);
        System.out.println("История: " + markForHistory);
        System.out.println("Программирование: " + markForProgramming);
        System.out.print("Средний балл оценок по предметам: "); 
        System.out.println(calculateAverage(markForHistory, markForProgramming));
        System.out.print("Средний % по предметам: ");  
        System.out.println(calculateAverage(percentMarkForHistory, percentMarkForProgramming));

        System.out.println("\n8. Расчет годовой прибыли");
        double productSaleForMonth = 13025.233;
        double rentForMonth = 5123.018;
        double productionCostForMonth = 9001.729;
        double profitForYear = 12 * (productSaleForMonth - rentForMonth - productionCostForMonth);
        System.out.print("Прибыль за год: ");
        if (profitForYear > 0) {
            System.out.print("+");
        }
        System.out.println(profitForYear + " руб.");

        System.out.println("\n9. *Расчет годовой прибыли");
        BigDecimal monthlySaleBigDec = new BigDecimal("13025.233");
        BigDecimal rentForMonthBigDec = new BigDecimal("5123.018");
        BigDecimal monthManufacturingBigDec = new BigDecimal("9001.729");
        BigDecimal numberOfMonths = BigDecimal.valueOf(12);
        BigDecimal monthlyProfitBigDec = monthlySaleBigDec.subtract(rentForMonthBigDec)
                .subtract(monthManufacturingBigDec);
        BigDecimal yearProfitBigDec = numberOfMonths.multiply(monthlyProfitBigDec);
        System.out.print("Прибыль за год: ");
        if (yearProfitBigDec.compareTo(BigDecimal.ZERO) > 0) {
            System.out.print("+");
        }
        System.out.println(yearProfitBigDec.setScale(2, RoundingMode.HALF_UP) + " руб.");

        System.out.println("\n10. *Подсчет начисленных банком %");
        BigDecimal depositBigDec = new BigDecimal("321123.59");
        BigDecimal percentBigDec = BigDecimal.valueOf(5);
        BigDecimal lowerLimit = BigDecimal.valueOf(100000);
        BigDecimal upperLimit = BigDecimal.valueOf(300000);
        if (depositBigDec.compareTo(lowerLimit) >= 0 && depositBigDec.compareTo(upperLimit) <= 0) {
            percentBigDec = BigDecimal.valueOf(7);
        } else if (depositBigDec.compareTo(upperLimit) > 0) {
            percentBigDec = BigDecimal.valueOf(10);
        }
        BigDecimal addedPercentBigDec = depositBigDec.multiply(percentBigDec).divide(new BigDecimal("100"));
        BigDecimal changedDepositBigDec = depositBigDec.add(addedPercentBigDec);
        System.out.println("Сумма вклада: " + depositBigDec.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Сумма начисленных %: " + addedPercentBigDec.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Итоговая сумма с %: " + changedDepositBigDec.setScale(2, RoundingMode.HALF_UP));
    }

    private static int toMark(int percent) { 
        if (percent > 91 && percent <= 100) {
            return 5;
        }
        if (percent > 73) {
            return 4;
        } 
        if (percent > 60) {
            return 3;
        }
        if (percent >= 0 && percent <= 60) {
            return 2;
        }
        return 0;
    }

    private static double calculateAverage(double first, double second) {
        return (first + second) / 2;
    }
}