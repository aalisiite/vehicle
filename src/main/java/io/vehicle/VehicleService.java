package io.vehicle;

import io.vehicle.api.Vehicle;
import io.vehicle.api.request.VehicleRequest;

import java.util.List;

public interface VehicleService<B extends Vehicle, R extends VehicleRequest> {

    B createVehicle(R request);

    String vehicleType();

    List<B> getVehicles();
}
