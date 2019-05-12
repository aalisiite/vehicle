package io.vehicle.repository.record;

import javax.persistence.*;

@Entity
@Table(name="vehicles")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class VehicleRecord {
    @Id
    @GeneratedValue(generator = "vehicle_seq_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "vehicle_seq_generator", sequenceName = "vehicle_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;

    public VehicleRecord(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
