package fuelInjection;

public interface Car {

    /**
     * 여행하려는 거리
     */
    double getTripDistance();

    /**
     * 차종의 이름
     */
    String getName();

    double getChargeQuantity();
}
