package io.vehicle.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class BicycleRequest extends VehicleRequest {
    @NotEmpty
    private String bicycleModel;

    @JsonCreator
    public BicycleRequest(@JsonProperty("name") @NotEmpty String name, @JsonProperty("bicycleModel") @NotEmpty String bicycleModel) {
        super(name);
        this.bicycleModel = bicycleModel;
    }

    public String getBicycleModel() {
        return bicycleModel;
    }

    public void setBicycleModel(String bicycleModel) {
        this.bicycleModel = bicycleModel;
    }

    @Override
    public String type() {
        return "bicycle";
    }
}
