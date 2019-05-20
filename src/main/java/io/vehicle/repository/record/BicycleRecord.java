package io.vehicle.repository.record;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BicycleRecord that = (BicycleRecord) o;
        return model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }
}
