import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static ArrayList<String> delimeters = new ArrayList<String>(Arrays.asList(":", ","));

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

    public static boolean isPositive(String s) {
        try {
            int i = Integer.parseInt(s);
            if (i < 0) throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static int splitAndSum(String s) {
        int sum = 0;
        String text = s;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimeters.add(customDelimiter);
            text = m.group(2);
        }
        String del = "";
        for (int i = 0; i < delimeters.size(); i++) {
            del += delimeters.get(i) + "|";
        }
        del = del.substring(0, del.length()-1);
        String[] nums = text.split(del);
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int sum = splitAndSum(in);
        System.out.println(sum);
    }
}
