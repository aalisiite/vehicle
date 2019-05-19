package io.vehicle.repository.record;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "bicycles")
public class BicycleRecord extends VehicleRecord {

    @Column(name = "model")
    @NotEmpty
    private String model;

    public BicycleRecord(String name) {
        super(name);
    }

    public BicycleRecord(String name, @NotEmpty String model) {
        super(name);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
