package fuelInjection;

public class Sonata extends PetrolCar {

    public Sonata(double tripDistance) {
        super("Sonata", tripDistance, 10);
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
