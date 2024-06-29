import static java.math.BigDecimal.ROUND_HALF_UP;

import java.math.BigDecimal;

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
        int age = 15;
        System.out.print("Если age = " + age + ", значит возраст ");
        if (age > 18) {
            System.out.println("больше 18 лет.");
        } else {
            System.out.println("меньше или равен 18 годам.");
        }
        double height = 1.8;
        System.out.print("Если height = " + height + ", значит рост ");
        if (height < 1.8) {
            System.out.println("меньше 1,8 м.");
        } else {
            System.out.println("1,8 м или больше.");
        }
        String name = "Peter";
        char firstLetterOfName = name.charAt(0);
        System.out.print("Первая буква имени " + name);
        if (firstLetterOfName == 'M') {
            System.out.println(" - M.");
        } else if (firstLetterOfName == 'I') {
            System.out.println(" - I.");
        } else {
            System.out.println(" не M и не I.");
        }

        System.out.println("\n2. Поиск большего числа");
        int firstNum = 242334;
        int secondNum = -99;
        if (firstNum > secondNum) {
            System.out.println(firstNum + " > " + secondNum);
        } else if (firstNum < secondNum) {
            System.out.println(firstNum + " < " + secondNum);
        } else {
            System.out.println(firstNum + " = " + secondNum);
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
        if (firstInt % 10 != secondInt % 10 && 
                firstInt % 100 - firstInt % 10 != secondInt % 100 - secondInt % 10 &&
                firstInt % 1000 - firstInt % 100 != secondInt % 1000 - secondInt % 100) {
            System.out.println("Равных цифр нет.");
        } else {
            System.out.println("Исходные числа: " + firstInt + " и " + secondInt);
            if (firstInt % 10 == secondInt % 10) {
                System.out.println("Одинаковые цифры: " + firstInt % 10 + " в разряде 1.");
            }
            if (firstInt % 100 - firstInt % 10 == secondInt % 100 - secondInt % 10) {
                System.out.print("Одинаковые цифры: ");
                System.out.println(((firstInt % 100 - firstInt % 10) / 10) + " в разряде 2.");
            }
            if (firstInt % 1000 - firstInt % 100 == secondInt % 1000 - secondInt % 100) {
                System.out.print("Одинаковые цифры: ");
                System.out.println(((firstInt % 1000 - firstInt % 100) / 100) + " в разряде 3.");
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
        int percent = 5;
        if (deposit >= 100000 && deposit <= 300000) {
            percent = 7;
        } else if (deposit > 300000) {
            percent = 10;
        }
        System.out.println("Сумма вклада: " + deposit);
        double addedPercent = deposit * percent / 100;
        System.out.println("Сумма начисленного %: " + addedPercent);
        double changedDeposit = deposit + addedPercent;
        System.out.println("Итоговая сумма с %: " + changedDeposit);

        System.out.println("\n7. Определение оценки по предметам");
        int percentForHistory = 59;
        int percentForProgramming = 92;
        int markForHistory = getMark(percentForHistory);
        int markForProgramming = getMark(percentForProgramming);
        System.out.println("История: " + markForHistory);
        System.out.println("Программирование: " + markForProgramming);
        System.out.print("Средний балл оценок по предметам: "); 
        System.out.println(countAverage(markForHistory, markForProgramming));
        System.out.print("Средний % по предметам: ");  
        System.out.println(countAverage(percentForHistory, percentForProgramming));

        System.out.println("\n8. Расчет годовой прибыли");
        double productSaleForMonth = 13025.233;
        double rentForMonth = 5123.018;
        double productionCostForMonth = 9001.729;
        double profitForYear = 12 * (productSaleForMonth - rentForMonth - productionCostForMonth);
        System.out.print("Прибыль за год: ");
        if (profitForYear == 0) {
            System.out.println("0 руб.");
        } else if (profitForYear > 0) {
            System.out.println("+" + profitForYear + " руб.");
        } else {
            System.out.println(profitForYear + " руб.");
        }

        System.out.println("\n9. *Расчет годовой прибыли");
        BigDecimal monthlySaleBigDec = new BigDecimal("13025.233");
        BigDecimal rentForMonthBigDec = new BigDecimal("5123.018");
        BigDecimal monthManufacturingBigDec = new BigDecimal("9001.729");
        BigDecimal numberOfMonths = new BigDecimal("12");
        BigDecimal monthlyProfitBigDec = monthlySaleBigDec.subtract(rentForMonthBigDec)
                .subtract(monthManufacturingBigDec);
        BigDecimal yearProfitBigDec = numberOfMonths.multiply(monthlyProfitBigDec);
        System.out.print("Прибыль за год: ");
        if (yearProfitBigDec.compareTo(new BigDecimal("0")) == 0) {
            System.out.println("0 руб.");
        } else if (yearProfitBigDec.compareTo(new BigDecimal("0")) > 0) {
            System.out.println("+" + yearProfitBigDec.setScale(2, ROUND_HALF_UP) + " руб.");
        } else {
            System.out.println(yearProfitBigDec.setScale(2, ROUND_HALF_UP) + " руб.");
        }

        System.out.println("\n10. *Подсчет начисленных банком %");
        BigDecimal depositBigDec = new BigDecimal("321123.59");
        BigDecimal percentBigDec = new BigDecimal("5");
        BigDecimal lowerLimit = new BigDecimal("100000");
        BigDecimal upperLimit = new BigDecimal("300000");
        if (depositBigDec.compareTo(lowerLimit) >= 0 && depositBigDec.compareTo(upperLimit) <= 0) {
            percentBigDec = new BigDecimal("7");
        } else if (depositBigDec.compareTo(upperLimit) > 0) {
            percentBigDec = new BigDecimal("10");
        }
        System.out.println("Сумма вклада: " + depositBigDec.setScale(2, ROUND_HALF_UP));
        BigDecimal addedPercentBigDec = depositBigDec.multiply(percentBigDec).divide(new BigDecimal("100"));
        System.out.println("Сумма начисленных %: " + addedPercentBigDec.setScale(2, ROUND_HALF_UP));
        BigDecimal changedDepositBigDec = depositBigDec.add(addedPercentBigDec);
        System.out.println("Итоговая сумма ñ %: " + changedDepositBigDec.setScale(2, ROUND_HALF_UP));
    }

    public static int getMark(int percents) {
        if (percents > 100 || percents < 0) {
            return 0;
        } 
        if (percents > 91) {
            return 5;
        } else if (percents > 73) {
            return 4;
        } else if (percents > 60) {
            return 3;
        } else {
            return 2;
        }
    }

    public static double countAverage(double first, double second) {
        return (first + second) / 2;
    }
}