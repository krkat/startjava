public class BooleanMethods {
    public boolean canProgramContinue() {
        System.out.print("\n" + MethodNameUtil.get() + 
                "() -> выполняется ли далее программа или завершается? ");
        return true;
    }

    public boolean isDeletedFile() {
        System.out.print("\n" + MethodNameUtil.get() + 
                "() -> удалился ли файл на жестком диске или флешке? ");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print("\n" + MethodNameUtil.get() + 
                "() -> последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> пользователь ввел букву или что-то другое? ");
        return false;
    }

    public boolean hasEqualDigits() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public boolean hasAttempt() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isEmpty() {
        System.out.print("\n" + MethodNameUtil.get() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEven() {
        System.out.print("\n" + MethodNameUtil.get() + 
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return false;
    }

    public boolean isValidPath() {
        System.out.print("\n" + MethodNameUtil.get() + 
                "() -> путь до файла, который вы ищете на ssd, действительный? ");
        return false;
    }

    public boolean isExistFile() {
        System.out.print("\n" + MethodNameUtil.get() + "() -> файл по указанному адресу существует? ");
        return false;
    }
}