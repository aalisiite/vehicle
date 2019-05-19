package io.vehicle.repository.record;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cars")
public class CarRecord extends VehicleRecord {

    @Column(name = "model")
    @NotEmpty
    private String model;

    public CarRecord(String company) {
        super(company);
    }

    public CarRecord(String company, @NotEmpty String model) {
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
