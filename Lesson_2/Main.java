import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        doNonBooleanMethods();
        doBooleanMethods();
    }

    private static void doNonBooleanMethods() {
        NonBooleanMethods nonBm = new NonBooleanMethods();
        
        nonBm.findLongestWord();
        nonBm.chooseMenuItem();
        nonBm.avgMark();
        nonBm.countUniqueWords();
        nonBm.showErrorMessage();
        nonBm.syncWithCloud();
        nonBm.restoreBackup();
        nonBm.pauseDownloadFile();
        nonBm.resetToDefault();
        nonBm.writeFile();
        nonBm.fromCelsiusToFahrenheit();
        nonBm.inputMathExpression();
        nonBm.identifyWinner();
        nonBm.findBookByAuthor();
        nonBm.saveClipboardToFile();
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
        System.out.print(bm.isEmpty());
        System.out.print(bm.isEven());
        System.out.print(bm.isValidPath());
        System.out.print(bm.isExistFile());
    }
}