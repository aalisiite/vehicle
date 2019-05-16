package io.vehicle.api;

public abstract class Vehicle {
    private Long id;
    private String company;

    public Vehicle(Long id, String company) {
        this.id = id;
        this.company= company;
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
}
