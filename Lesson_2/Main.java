import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        NotBooleanMethods notBooleanMethods = new NotBooleanMethods();
        callNotBooleanMethods(notBooleanMethods);
        System.out.println();

        BooleanMethods booleanMethods = new BooleanMethods();
        callBooleanMethods(booleanMethods);
    }

    private static void callNotBooleanMethods(NotBooleanMethods notBooleanMethods) {
        notBooleanMethods.findTheLongestWord();
        notBooleanMethods.chooseMenuItem();
        notBooleanMethods.avgMark();
        notBooleanMethods.countUniqueWords();
        notBooleanMethods.showMessage();
        notBooleanMethods.synchronizeWithCloud();
        notBooleanMethods.restoreData();
        notBooleanMethods.pauseDownloadFile();
        notBooleanMethods.resetToDefault();
        notBooleanMethods.writeFile();
        notBooleanMethods.fromCelsiusToFahrenheit();
        notBooleanMethods.inputMathExpression();
        notBooleanMethods.identifyWinner();
        notBooleanMethods.findBookByAuthor();
        notBooleanMethods.saveClipboardToFile();
    }

    private static void callBooleanMethods(BooleanMethods booleanMethods) {
        boolean result = booleanMethods.canProgramContinue();
        System.out.print(result); 
        result = booleanMethods.isDeletedFile();
        System.out.print(result);
        result = booleanMethods.hasUniqueDigit();
        System.out.print(result);
        result = booleanMethods.isLetter();
        System.out.print(result);
        result = booleanMethods.hasEqualDigits();
        System.out.print(result);
        result = booleanMethods.hasAttempt();
        System.out.print(result);
        result = booleanMethods.isNullOrHasJustSpacesString();
        System.out.print(result);
        result = booleanMethods.isEven();
        System.out.print(result);
        result = booleanMethods.isValidPath();
        System.out.print(result);
        result = booleanMethods.isExistFile();
        System.out.print(result);
    }
}