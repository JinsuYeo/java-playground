package fuelInjection;

public abstract class PetrolCar implements Car {

    String name;
    double tripDistance;
    double distancePerLiter;

    public PetrolCar(String name, double tripDistance, double distancePerLiter) {
        this.name = name;
        this.tripDistance = tripDistance;
        this.distancePerLiter = distancePerLiter;
    }

    /**
     * 리터당 이동 거리. 즉, 연비
     */
    abstract double getDistancePerLiter();

    /**
     * 주입해야할 연료량을 구한다.
     */
    @Override
    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
