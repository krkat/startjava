public class MethodNameUtil {
    public static String get() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}