import java.math.BigInteger;

public class NotBooleanMethod {
    public String findTheLongestWord() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> "); 
        System.out.print("найти самое длинное слово в предложении из книги по Java: ");
        return "документация";
    }

    public String chooseMenuItem() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> "); 
        System.out.print("выбрать пункт меню в текстовом редакторе на macOS: ");
        return "File";
    }

    public float avgMark() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> "); 
        System.out.print("вычислить среднее значение оценок в школе №1234: ");
        return 4f;
    }

    public BigInteger countUniqueWords() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> "); 
        System.out.print("подсчитать количество уникальных слов в \"Война и Мир\": ");
        return BigInteger.valueOf(3000);
    }

    public void showMessage() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("вывести сообщение об ошибке ");
    }

    public void synchronizeWithCloud() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("синхронизировать данные с облачным хранилищем ");
    }

    public void restoreData() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("восстановить данные из резервной копии от 11.03.2024 ");
    }

    public void pauseDownloadFile() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("приостановить загрузку mp3-файла группы \"Ария\" ");
    }

    public void resetToDefault() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("сбросить настройки до заводских для пылесоса Mi ");   
    }

    public void writeFile() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("записать содержимое в файл по указанному пути на флешку ");
    }
    
    public float fromCelsiusToFahrenheit() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("преобразовать температуру из Цельсия в Фаренгейт: ");
        return 451f;
    }

    public String inputMathExpression() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("ввести математическое выражение с тремя аргументами: ");
        return "a + b + c";
    }
    
    public String identifyWinner() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("выявить победителя среди гонщиков игры \"Need For Speed\": ");
        return "Peter";
    }
    
    public String findBookByAuthor() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("найти книгу по имени писателя: ");
        return "Война и мир";
    }

    public void saveClipboardToFile() {
        System.out.print("\n" + NameMethod.extractMethodName() + "() -> ");
        System.out.print("сохранить содержимое из буфера обмена в файл Buffer.txt ");
    }
}