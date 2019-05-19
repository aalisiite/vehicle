package io.vehicle.repository.record;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "bicycles")
public class BicycleRecord extends VehicleRecord {

    @Column(name = "model")
    @NotEmpty
    private String model;

    public BicycleRecord() {
    }

    public BicycleRecord(String company, @NotEmpty String model) {
        super(company);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
