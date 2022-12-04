import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static boolean isInt(String s) throws RuntimeException {
        try {
            int i = Integer.parseInt(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
