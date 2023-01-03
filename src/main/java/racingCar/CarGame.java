package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

public class CarGame {
    List<Car> cars;

    public CarGame(List<String> carNames) {
        cars = new ArrayList<>();
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void moveCar(int testNum) {
        cars.stream().forEach(car -> {
            car.move(testNum);
        });
    }

    public List<String> getMovingResult() {
        List<String> movingResult = new ArrayList<String>();
        cars.stream().forEach(car -> {
            String moveString = "-";
            for(int i = 0; i < car.countMoving(); i++) {
                moveString += "-";
            }
            movingResult.add(moveString);
        });
        return movingResult;
    }
}
