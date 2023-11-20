package racingCar;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public boolean isMoved(int value) {
        return value >= 4;
    }

    public void move(int value) {
        if (value >= 4) {
            this.position++;
        }
    }

    public int countMoving() {
        return this.position;
    }

    public String getName() {
        return name;
    }
}
