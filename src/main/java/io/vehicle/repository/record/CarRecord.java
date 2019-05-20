package io.vehicle.repository.record;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class CarRecord extends VehicleRecord {

    @Column(name = "model")
    @NotEmpty
    private String model;

    public CarRecord() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRecord carRecord = (CarRecord) o;
        return model.equals(carRecord.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }
}
