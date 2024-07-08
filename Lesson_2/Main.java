import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        doNotBooleanMethods();
        doBooleanMethods();
    }

    private static void doNotBooleanMethods() {
        NotBooleanMethods notBm = new NotBooleanMethods();
        
        notBm.findLongestWord();
        notBm.chooseMenuItem();
        notBm.avgMark();
        notBm.countUniqueWords();
        notBm.showMessage();
        notBm.synchronizeWithCloud();
        notBm.restoreData();
        notBm.pauseDownloadFile();
        notBm.resetToDefault();
        notBm.writeFile();
        notBm.fromCelsiusToFahrenheit();
        notBm.inputMathExpression();
        notBm.identifyWinner();
        notBm.findBookByAuthor();
        notBm.saveClipboardToFile();
        System.out.println();
    }

    private static void doBooleanMethods() {
        BooleanMethods bm = new BooleanMethods();

        System.out.print(bm.canProgramContinue()); 
        System.out.print(bm.isDeletedFile());
        System.out.print(bm.hasUniqueDigit());
        System.out.print(bm.isLetter());
        System.out.print(bm.hasEqualDigits());
        System.out.print(bm.hasAttempt());
        System.out.print(bm.isNullOrHasJustSpacesString());
        System.out.print(bm.isEven());
        System.out.print(bm.isValidPath());
        System.out.print(bm.isExistFile());
    }
}