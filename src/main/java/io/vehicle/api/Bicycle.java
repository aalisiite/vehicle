package io.vehicle.api;


public class Bicycle extends Vehicle {
    private String model;

    public Bicycle(Long id, String name, String model) {
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
