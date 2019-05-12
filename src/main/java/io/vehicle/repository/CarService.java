package io.vehicle.repository;

import io.vehicle.api.Car;
import io.vehicle.api.request.CarRequest;
import io.vehicle.repository.mapping.MapCarRecordToCar;
import io.vehicle.repository.record.CarRecord;
import org.springframework.stereotype.Component;
import io.vehicle.VehicleService;

@Component
public class CarService implements VehicleService<Car, CarRequest> {
    private CarRecordRepository repository;
    private MapCarRecordToCar recordToCar;

    public CarService(CarRecordRepository repository, MapCarRecordToCar recordToCar) {
        this.repository = repository;
        this.recordToCar = recordToCar;
    }

    @Override
    public Car createVehicle(CarRequest request) {
        CarRecord car = new CarRecord(
                request.getName(),
                request.getCarModel()
        );
        repository.save(car);
        return recordToCar.apply(car);
    }
}
