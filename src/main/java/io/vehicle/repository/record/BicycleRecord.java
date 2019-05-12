package io.vehicle.repository.record;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "bicycles")
public class BicycleRecord extends VehicleRecord {

    @Column(name = "bicycles_model")
    @NotEmpty
    private String bicycleModel;

    public BicycleRecord(String name, @NotEmpty String bicycleModel) {
        super(name);
        this.bicycleModel = bicycleModel;
    }

    public String getBicycleModel() {
        return bicycleModel;
    }

    public void setBicycleModel(String bicycleModel) {
        this.bicycleModel = bicycleModel;
    }
}
