package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static String DELIMETER = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String inputString = scanner.nextLine();
        return createCarNames(inputString);
    }

    public static List<String> createCarNames(String string) throws IllegalArgumentException {
        List<String> carNames = splitNames(string);
        checkCarNames(carNames);
        return carNames;
    }

    public static void checkCarNames(List<String> carNames) throws IllegalArgumentException {
        if(carNames.stream().anyMatch(name -> !isValidLength(name))) {
            throw new IllegalArgumentException("자동차 이름은 5자 이내여야 합니다.");
        }
    }

    public static List<String> splitNames(String string) {
        return Arrays.asList(string.split(DELIMETER));
    }

    public static boolean isValidLength(String carName) {
        return carName.length() <= 5;
    }

    public static int inputNumberOfAttempts() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        int attempt = 0;
        try {
            attempt = scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }

        return attempt;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
