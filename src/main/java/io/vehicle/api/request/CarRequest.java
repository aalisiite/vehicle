package io.vehicle.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class CarRequest extends VehicleRequest {
    @NotEmpty
    private String carModel;

    @JsonCreator
    public CarRequest(@JsonProperty("name") @NotEmpty String name,
                      @JsonProperty("carModel") @NotEmpty String carModel) {
        super(name);
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public String type() {
        return "car";
    }
}
