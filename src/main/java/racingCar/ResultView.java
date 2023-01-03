package racingCar;

import java.util.List;

public class ResultView {
    public static void printCarMoving(List<String> carNames, List<String> movingResult) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + movingResult.get(i));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.println(makeWinnerName(winners) + "가 최종 우승했습니다.");
    }

    private static String makeWinnerName(List<String> winners) {
        String winnerName = "";
        for(int i = 0; i < winners.size(); i++) {
            if(i == winners.size() - 1) {
                winnerName += winners.get(i);
                break;
            }
            winnerName += winners.get(i) + ", ";
        }
        return winnerName;
    }
}
