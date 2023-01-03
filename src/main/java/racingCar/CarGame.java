package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

public class CarGame {
    List<Car> cars;
    Random random;

    public CarGame(List<String> carNames) {
        cars = new ArrayList<>();
        makeCars(carNames);
        makeRandom();
    }

    private void makeCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void makeRandom() {
        this.random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    public void moveCar() {
        cars.stream().forEach(car -> {
            car.move(random.nextInt(9));
        });
    }

    public void moveCar(int testNum) {
        cars.stream().forEach(car -> {
            car.move(testNum);
        });
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<String>();
        cars.stream().forEach(car -> {
            carNames.add(car.getName());
        });
        return carNames;
    }

    public List<String> getMovingResult() {
        List<String> movingResult = new ArrayList<String>();
        cars.stream().forEach(car -> {
            movingResult.add(makeMoveString(car));
        });
        return movingResult;
    }

    private String makeMoveString(Car car) {
        String moveString = "-";
        for (int i = 0; i < car.countMoving(); i++) {
            moveString += "-";
        }
        return moveString;
    }

    public List<String> getWinner() {
        int maxMoving = calcMaxMoving();
        return cars.stream()
                .filter(car -> car.countMoving() == maxMoving)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int calcMaxMoving() {
        int maxMoving = cars.stream()
                .map(car -> car.countMoving())
                .mapToInt(i -> i)
                .max()
                .orElseThrow(NoSuchElementException::new);
        return maxMoving;
    }
}
