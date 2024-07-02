import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера");
        int volumeSsd = 512;
        System.out.println("Объем ssd: " + volumeSsd + "Гб");
        short volumeRam = 16;
        System.out.println("Объем оперативной памяти: " + volumeRam + "Гб");
        long speedRam = 4800;
        System.out.println("Частота оперативной памяти: " + speedRam + "МГц");
        byte countCores = 8;
        System.out.println("Количество ядер процессора: " + countCores);
        float speedCpu = 2;
        System.out.println("Частота процессора: " + speedCpu + "ГГц");
        double accumulatorCapacity = 53.5;
        System.out.println("Емкость аккумулятора: " + accumulatorCapacity + "Вт*ч");
        char systemDisk = 'C';
        System.out.println("Системный диск: " + systemDisk);
        boolean hasUsbTypeC = true;
        System.out.println("Есть разъем Usb type C: " + hasUsbTypeC);

        System.out.println("\n2. Расчет стоимости товара со скидкой");
        double penPrice = 105.5;
        double bookPrice = 235.83;
        double basePrice = penPrice + bookPrice;
        double discount = basePrice * 0.11;
        double discountPrice = basePrice - discount;
        System.out.printf("Стоимость товаров без скидки: %.2f%n", basePrice);
        System.out.printf("Сумма скидки: %.2f%n", discount);       
        System.out.printf("Стоимость товаров со скидкой: %.2f%n", discountPrice);

        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  V     V  a");
        System.out.println("   J   a a  V   V  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        byte extremesByteValue = 127;
        System.out.println("Первоначальное значение byte: " + extremesByteValue);
        System.out.println("Значение после инкремента на 1: " + ++extremesByteValue);
        System.out.println("Значение после декремента на 1: " + --extremesByteValue);
        short extremesShortValue = 32767;
        System.out.println("\nПервоначальное значение short: " + extremesShortValue);
        System.out.println("Значение после инкремента на 1: " + ++extremesShortValue);
        System.out.println("Значение после декремента на 1: " + --extremesShortValue);
        int extremesIntValue = 2147483647;
        System.out.println("\nПервоначальное значение int: " + extremesIntValue);
        System.out.println("Значение после инкремента на 1: " + ++extremesIntValue);
        System.out.println("Значение после декремента на 1: " + --extremesIntValue);
        long extremesLongValue = 9223372036854775807L;
        System.out.println("\nПервоначальное значение long: " + extremesLongValue);
        System.out.println("Значение после инкремента на 1: " + ++extremesLongValue);
        System.out.println("Значение после декремента на 1: " + --extremesLongValue);
        char extremesCharValue = 65535;
        System.out.println("\nПервоначальное значение char: " + (int) extremesCharValue);
        System.out.println("Значение после инкремента на 1: " + (int) ++extremesCharValue);
        System.out.println("Значение после декремента на 1: " + (int) --extremesCharValue);

        System.out.println("\n5. Перестановка значений переменных");
        int a = 2;
        int b = 5;
        System.out.printf("Исходные значения: a - %d, b - %d", a, b);
        System.out.println("\nС помощью третьей переменной:");
        int swap = a;
        a = b;
        b = swap; 
        System.out.printf("a - %d, b - %d", a, b);
        System.out.println("\nС помощью арифметических операций:");
        a += b;
        b = a - b;
        a -= b; 
        System.out.printf("a - %d, b - %d", a, b);
        System.out.println("\nС помощью побитовой операции ^:");
        a ^= b;
        b ^= a;
        a ^= b; 
        System.out.printf("a - %d, b - %d", a, b);
        
        System.out.println("\n\n6. Вывод символов и их кодов");
        char dollar = '$';
        char asterisk = '*';
        char atSign = '@';
        char pipe = '|';
        char tilde = '~';
        System.out.println((int) dollar + " " + dollar);
        System.out.println((int) asterisk + " " + asterisk);
        System.out.println((int) atSign + " " + atSign);
        System.out.println((int) pipe + " " + pipe);
        System.out.println((int) tilde + " " + tilde);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        char slash = '/';
        char backSlash = '\\';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        char underscore = '_';
        System.out.printf("    %c%c%n", slash, backSlash);
        System.out.printf("   %c  %c%n", slash, backSlash);
        System.out.printf("  %c%c%c %c%c%n", slash, underscore, leftParenthesis, rightParenthesis, backSlash);
        System.out.printf(" %c      %c%n", slash, backSlash);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%n", slash, underscore, underscore, underscore, underscore, 
                slash, backSlash, underscore, underscore, backSlash);

        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа");
        int originNumber = 123;
        int ones = originNumber % 10;
        int tens = originNumber % 100 / 10;
        int hundreds = originNumber / 100;
        System.out.println("Число " + originNumber + " содержит:");
        System.out.println("    сотен = " + hundreds);
        System.out.println("    десятков = " + tens);
        System.out.println("    единиц = " + ones);
        int sumDigits = ones + tens + hundreds;
        int multiplicationDigits = ones * tens * hundreds;
        System.out.println("Сумма разрядов = " + sumDigits);
        System.out.println("Произведение разрядов = " + multiplicationDigits); 

        System.out.println("\n9. Перевод секунд в часы, минуты и секунды");
        int totalSeconds = 86399;
        int ss = totalSeconds % 60; 
        int mm = totalSeconds % 3600 / 60;
        int hh = totalSeconds / 3600;
        System.out.printf("%d:%d:%d%n", hh, mm, ss);

        System.out.println("\n10. *Расчет стоимости товара со скидкой");
        BigDecimal penPriceBigDec = new BigDecimal(105.5);
        BigDecimal bookPriceBigDec = new BigDecimal(235.83);
        BigDecimal basePriceBigDec = penPriceBigDec.add(bookPriceBigDec);
        BigDecimal discountBigDec = basePriceBigDec.multiply(new BigDecimal(0.11));
        BigDecimal discountPriceBigDec = basePriceBigDec.subtract(discountBigDec);
        System.out.println("Стоимость товаров без скидки: " +
                basePriceBigDec.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Сумма скидки: " + discountBigDec.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Стоимость товаров со скидкой: " + 
                discountPriceBigDec.setScale(2, RoundingMode.HALF_UP));
    }
}