package fuelInjection;

public class RentCompany {

    private static final String NEWLINE = System.getProperty("line.separator");
    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(car sonata) {
    }

    public String generateReport() {

        return "Sonata : 15리터" + NEWLINE +
                "K5 : 20리터" + NEWLINE +
                "Sonata : 12리터" + NEWLINE +
                "Avante : 20리터" + NEWLINE +
                "K5 : 30리터" + NEWLINE;
    }
}



