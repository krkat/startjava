import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        NotBooleanMethod notBooleanMethod = new NotBooleanMethod();
        callNotBooleanMethods(notBooleanMethod);
        System.out.println();

        BooleanMethod booleanMethod = new BooleanMethod();
        callBooleanMethods(booleanMethod);
    }

    private static void callNotBooleanMethods(NotBooleanMethod notBooleanMethod) {
        notBooleanMethod.findTheLongestWord();
        notBooleanMethod.chooseMenuItem();
        notBooleanMethod.avgMark();
        notBooleanMethod.countUniqueWords();
        notBooleanMethod.showMessage();
        notBooleanMethod.synchronizeWithCloud();
        notBooleanMethod.restoreData();
        notBooleanMethod.pauseDownloadFile();
        notBooleanMethod.resetToDefault();
        notBooleanMethod.writeFile();
        notBooleanMethod.fromCelsiusToFahrenheit();
        notBooleanMethod.inputMathExpression();
        notBooleanMethod.identifyWinner();
        notBooleanMethod.findBookByAuthor();
        notBooleanMethod.saveClipboardToFile();
    }

    private static void callBooleanMethods(BooleanMethod booleanMethod) {
        boolean result = booleanMethod.canProgramContinue();
        System.out.print(result); 
        result = booleanMethod.isDeletedFile();
        System.out.print(result);
        result = booleanMethod.hasUniqueDigit();
        System.out.print(result);
        result = booleanMethod.isLetter();
        System.out.print(result);
        result = booleanMethod.hasEqualDigits();
        System.out.print(result);
        result = booleanMethod.hasAttempt();
        System.out.print(result);
        result = booleanMethod.isNullOrHasJustSpacesString();
        System.out.print(result);
        result = booleanMethod.isEven();
        System.out.print(result);
        result = booleanMethod.isValidPath();
        System.out.print(result);
        result = booleanMethod.isExistFile();
        System.out.print(result);
    }
}