package io.vehicle.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class CarRequest extends VehicleRequest {
    @NotEmpty
    private String model;

    @JsonCreator
    public CarRequest(@JsonProperty("company") @NotEmpty String company,
                      @JsonProperty("model") @NotEmpty String model) {
        super(company);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String carModel) {
        this.model = model;
    }

    @Override
    public String type() {
        return "car";
    }
}
