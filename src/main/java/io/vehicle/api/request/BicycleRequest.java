package io.vehicle.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class BicycleRequest extends VehicleRequest {
    @NotEmpty
    private String model;

    @JsonCreator
    public BicycleRequest(@JsonProperty("name") @NotEmpty String name, @JsonProperty("model") @NotEmpty String model) {
        super(name);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String type() {
        return "bicycle";
    }
}
