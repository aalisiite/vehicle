package io.vehicle.repository.record;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cars")
public class CarRecord extends VehicleRecord {

    @Column(name = "cars_model")
    @NotEmpty
    private String carModel;

    public CarRecord(String name, @NotEmpty String carModel) {
        super(name);
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
