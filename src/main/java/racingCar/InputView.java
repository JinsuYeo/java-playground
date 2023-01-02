package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static String DELIMETER = ",";

    public static List<String> inputCarNames() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        scanner.close();
        return createCarNames(inputString);
    }

    public static List<String> createCarNames(String string) throws IllegalArgumentException {
        List<String> carNames = splitNames(string);
        checkCarNames(carNames);
        return carNames;
    }

    private static void checkCarNames(List<String> carNames) throws IllegalArgumentException {
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

}
