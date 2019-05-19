package io.vehicle.api;

public class Car extends Vehicle {

    private String model;

    public Car(Long id, String name, String model) {
        super(id, name);
        this.model = model;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
