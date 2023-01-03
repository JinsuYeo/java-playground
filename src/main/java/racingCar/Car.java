package racingCar;

public class Car {
    private String name;
    private int moving;

    public Car(String name) {
        this.name = name;
        this.moving = 0;
    }

    public boolean isMoved(int value) {
        return value >= 4;
    }

    public void move(int value) {
        if(value >= 4) {
            this.moving++;
        }
    }

    public int countMoving() {
        return this.moving;
    }

    public String getName() {
        return name;
    }
}
