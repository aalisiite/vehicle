package io.vehicle.api.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BicycleRequest extends VehicleRequest {
    @NotEmpty
    private String bicycleModel;

    public BicycleRequest(@NotNull Long id, @NotEmpty String name, @NotEmpty String bicycleModel) {
        super(id, name);
        this.bicycleModel = bicycleModel;
    }

    public String getBicycleModel() {
        return bicycleModel;
    }

    public void setBicycleModel(String bicycleModel) {
        this.bicycleModel = bicycleModel;
    }
}
