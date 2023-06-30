package fuelInjection;

public class K5 extends PetrolCar {

    public K5(int tripDistance) {
        super("K5", tripDistance, 13);
    }

    @Override
    double getDistancePerLiter() {
        return this.distancePerLiter;
    }

    @Override
    public double getTripDistance() {
        return this.tripDistance;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
