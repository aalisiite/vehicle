package io.vehicle.repository.mapping;

import io.vehicle.api.Vehicle;
import io.vehicle.repository.record.VehicleRecord;

import java.util.function.Function;

public class MapVehicleRecordToVehicle implements Function<VehicleRecord, Vehicle> {

    @Override
    public Vehicle apply(VehicleRecord vehicleRecord){
        return new Vehicle(
                vehicleRecord.getId(),
                vehicleRecord.getName()
        );
    }
}
