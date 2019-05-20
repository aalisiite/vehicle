package io.vehicle.api;


import java.util.Objects;

public class Bicycle extends Vehicle {
    private String model;

    public Bicycle(Long id, String company, String model) {
        super(id, company);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return model.equals(bicycle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }
}
