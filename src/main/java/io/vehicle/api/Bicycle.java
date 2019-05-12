package io.vehicle.api;


public class Bicycle extends Vehicle {
    private String bicycleModel;

    public Bicycle(Long id, String name, String bicycleModel) {
        super(id, name);
        this.bicycleModel = bicycleModel;
    }

    public String getBicycleModel() {
        return bicycleModel;
    }

    public void setBicycleModel(String bicycleModel) {
        this.bicycleModel = bicycleModel;
    }
}
