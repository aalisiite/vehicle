package io.vehicle.repository.record;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vehicles")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class VehicleRecord {
    @Id
    @GeneratedValue(generator = "vehicle_seq_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "vehicle_seq_generator", sequenceName = "vehicle_seq", allocationSize = 1)
    private Long id;
    @Column(name = "company")
    private String company;

    VehicleRecord() {
    }

    VehicleRecord(String company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleRecord that = (VehicleRecord) o;
        return id.equals(that.id)
                && company.equals(that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company);
    }
}
