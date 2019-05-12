package io.vehicle.api;

public class Car extends Vehicle {

    private String carModel;

    public Car(Long id, String name, String carModel) {
        super(id, name);
        this.carModel = carModel;
    }


    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
