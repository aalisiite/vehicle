package io.vehicle.api;

import java.util.Objects;

public abstract class Vehicle {
    private Long id;
    private String company;

    Vehicle() {
    }

    Vehicle(Long id, String company) {
        this.id = id;
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
        Vehicle vehicle = (Vehicle) o;
        return id.equals(vehicle.id)
                && company.equals(vehicle.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company);
    }
}
