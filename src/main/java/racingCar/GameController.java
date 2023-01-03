package racingCar;

import jdk.internal.net.http.common.Pair;

import java.util.List;

public class GameController {

    private static List<String> receiveCarNames() {
        List<String> carNames;
        try {
            carNames = InputView.inputCarNames();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
        return carNames;
    }

    private static int receiveNumberOfAttempts() {
        int attempt;
        try {
            attempt = InputView.inputNumberOfAttempts();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
        return attempt;
    }

    private static List<String> receiveValidCarNames() {
        List<String> carNames = null;
        while ((carNames = receiveCarNames()) == null) ;
        return carNames;
    }

    private static int receiveValidNumberOfAttempts() {
        int attempt = 0;
        while ((attempt = receiveNumberOfAttempts()) == 0) ;
        return attempt;
    }

    private static void runCarGame(CarGame carGame, int attempt) {
        System.out.println("실행 결과");
        for (int i = 0; i < attempt; i++) {
            carGame.moveCar();
            ResultView.printCarMoving(carGame.getCarNames(), carGame.getMovingResult());
        }
        ResultView.printWinner(carGame.getWinner());
    }

    public static void main(String[] args) {
        runCarGame(new CarGame(receiveValidCarNames()), receiveValidNumberOfAttempts());
        InputView.closeScanner();
    }
}
