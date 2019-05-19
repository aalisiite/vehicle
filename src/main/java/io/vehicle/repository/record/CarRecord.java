package io.vehicle.repository.record;

import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cars")
public class CarRecord extends VehicleRecord {

    @Column(name = "model")
    @NotEmpty
    private String model;

    public CarRecord(String name) {
        super(name);
    }

    public CarRecord(String name, @NotEmpty String model) {
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
