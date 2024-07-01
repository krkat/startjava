import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера");
        int ssd = 512;
        System.out.println("Объем ssd: " + ssd + "Гб");
        short ram = 16;
        System.out.println("Объем оперативной памяти: " + ram + "Гб");
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
        double sum = penPrice + bookPrice;
        System.out.printf("Стоимость товаров без скидки: %.2f%n", sum);
        double discount = sum * 0.11;
        System.out.printf("Сумма скидки: %.2f%n", discount);
        double discountPrice = sum - discount;
        System.out.printf("Стоимость товаров со скидкой: %.2f%n", discountPrice);

        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  V     V  a");
        System.out.println("   J   a a  V   V  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        byte byteVar = 127;
        System.out.println("Первоначальное значение byte: " + byteVar);
        System.out.println("Значение после инкремента на 1: " + byteVar++);
        System.out.println("Значение после декремента на 1: " + byteVar--);
        short shortVar = 32767;
        System.out.println("\nПервоначальное значение short: " + shortVar);
        System.out.println("Значение после инкремента на 1: " + shortVar++);
        System.out.println("Значение после декремента на 1: " + shortVar--);
        int intVar = 2147483647;
        System.out.println("\nПервоначальное значение int: " + intVar);
        System.out.println("Значение после инкремента на 1: " + intVar++);
        System.out.println("Значение после декремента на 1: " + intVar--);
        long longVar = 9223372036854775807L;
        System.out.println("\nПервоначальное значение byte: " + longVar);
        System.out.println("Значение после инкремента на 1: " + longVar++);
        System.out.println("Значение после декремента на 1: " + longVar--);

        System.out.println("\n5. Перестановка значений переменных");
        int first = 2;
        int second = 5;
        System.out.printf("Исходные значения: first - %d, second - %d", first, second);
        System.out.println("\nС помощью третьей переменной:");
        int buffer = first;
        first = second;
        second = buffer; 
        System.out.printf("first - %d, second - %d", first, second);
        // TODO
        System.out.println("\nС помощью арифметических операций:");
        first = first + second;
        second = first - second;
        first = first - second; 
        System.out.printf("first - %d, second - %d", first, second);
        // TODO
        System.out.println("\nС помощью побитовой операции ^:");
        first = first ^ second;
        second = first ^ second;
        first = first ^ second; 
        System.out.printf("first - %d, second - %d", first, second);
        
        System.out.println("\n\n6. Вывод символов и их кодов");
        char char1 = '$';
        char char2 = '*';
        char char3 = '@';
        char char4 = '|';
        char char5 = '~';
        System.out.println((int) char1 + " " + char1);
        System.out.println((int) char2 + " " + char2);
        System.out.println((int) char3 + " " + char3);
        System.out.println((int) char4 + " " + char4);
        System.out.println((int) char5 + " " + char5);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        char slash = '/';
        char reverseSlash = '\\';
        char bracket = '(';
        char reverseBracket = ')';
        char line = '_';
        System.out.printf("    %c%c%n", slash, reverseSlash);
        System.out.printf("   %c  %c%n", slash, reverseSlash);
        System.out.printf("  %c%c%c %c%c%n", slash, line, bracket, reverseBracket, reverseSlash);
        System.out.printf(" %c      %c%n", slash, reverseSlash);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c%n", slash, line, line, line, line, slash, 
                    reverseSlash, line, line, reverseSlash);

        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа");
        int number = 123;
        int ones = number % 10;
        int tens = number % 100 / 10;
        int hundreds = number % 1000 / 100;
        System.out.println("Число " + number + " содержит:");
        System.out.println("\tсотен = " + hundreds);
        System.out.println("\tдесятков = " + tens);
        System.out.println("\tединиц = " + ones);
        int sumDigits = ones + tens + hundreds;
        int multiplyDigits = ones * tens * hundreds;
        System.out.println("Сумма разрядов = " + sumDigits);
        System.out.println("Произведение разрядов = " + multiplyDigits); 

        System.out.println("\n9. Перевод секунд в часы, минуты и секунды");
        int totalSeconds = 86399;
        int seconds = totalSeconds % 60; 
        int minutes = totalSeconds % 3600 / 60;
        int hours = totalSeconds % 216000 / 3600;
        System.out.printf("%d:%d:%d%n", hours, minutes, seconds);

        System.out.println("\n10. *Расчет стоимости товара со скидкой");
        BigDecimal penPriceBigDec = new BigDecimal(105.5);
        BigDecimal bookPriceBigDec = new BigDecimal(235.83);
        BigDecimal sumBigDec = penPriceBigDec.add(bookPriceBigDec);
        System.out.println("Стоимость товаров без скидки: " +
                    sumBigDec.setScale(2, RoundingMode.HALF_UP));
        BigDecimal discountBigDec = sumBigDec.multiply(new BigDecimal(0.11));
        System.out.println("Сумма скидки: " + discountBigDec.setScale(2, RoundingMode.HALF_UP));
        BigDecimal discountPriceBigDec = sumBigDec.subtract(discountBigDec);
        System.out.println("Стоимость товаров со скидкой: " + 
                    discountPriceBigDec.setScale(2, RoundingMode.HALF_UP));
    }
}