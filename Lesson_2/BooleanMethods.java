public class BooleanMethods {
    public boolean canProgramContinue() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> ");
        System.out.print("выполняется ли далее программа или завершается? ");
        return true;
    }

    public boolean isDeletedFile() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> ");
        System.out.print("удалился ли файл на жестком диске или флешке? ");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> ");
        System.out.print("последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> ");
        System.out.print("пользователь ввел букву или что-то другое? ");
        return false;
    }

    public boolean hasEqualDigits() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> ");
        System.out.print("в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public boolean hasAttempt() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> ");
        System.out.print("в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isNullOrHasJustSpacesString() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> ");
        System.out.print("пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEven() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> ");
        System.out.print("на кубике, который бросил компьютер, выпало четное число? ");
        return false;
    }

    public boolean isValidPath() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> ");
        System.out.print("путь до файла, который вы ищете на ssd, действительный? ");
        return false;
    }

    public boolean isExistFile() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> ");
        System.out.print("файл по указанному адресу существует? ");
        return false;
    }
}