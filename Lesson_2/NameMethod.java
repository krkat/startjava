public class NameMethod {
    public static String extractMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[2].getMethodName();
    }
}