package fuelInjection;

public class Avante extends PetrolCar {

    public Avante(int tripDistance) {
        super("Avante", tripDistance, 15);
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


