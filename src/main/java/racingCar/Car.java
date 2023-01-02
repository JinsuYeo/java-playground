package racingCar;

public class Car {
    private int moving;
    private Engine engine;

    public Car() {
        this.moving = 0;
        this.engine = new Engine();
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
}
