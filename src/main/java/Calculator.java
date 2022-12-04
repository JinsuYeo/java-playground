import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static List<String> delimeters = Arrays.asList(":", ",");

    public static boolean isInt(String s) throws RuntimeException {
        try {
            int i = Integer.parseInt(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean isDelimeter(String s) {
        return delimeters.stream().anyMatch(str -> s.equals(str));
    }

}
