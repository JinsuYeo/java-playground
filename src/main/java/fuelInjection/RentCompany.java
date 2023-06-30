package fuelInjection;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private List<Car> cars;

    private static final String NEWLINE = System.getProperty("line.separator");
    public static RentCompany create() {
        RentCompany rentCompany = new RentCompany();
        rentCompany.cars = new ArrayList<>();
        return rentCompany;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public String generateReport() {

        String report = "";
        for(Car car : cars) {
            report += getReport(car);
        }

        return report;
    }

    private String getReport(Car car) {
        return car.getName() + " : " + (int)car.getChargeQuantity() + "리터" + NEWLINE;
    }
}



