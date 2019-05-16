package io.vehicle.repository;

import io.vehicle.api.Car;
import io.vehicle.api.request.CarRequest;
import io.vehicle.repository.mapping.MapCarRecordToCar;
import io.vehicle.repository.record.CarRecord;
import org.springframework.stereotype.Component;
import io.vehicle.VehicleService;

@Component
class CarService implements VehicleService<Car, CarRequest> {
    private CarRecordRepository repository;
    private MapCarRecordToCar recordToCar = new MapCarRecordToCar();

    public CarService(CarRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public Car createVehicle(CarRequest request) {
        CarRecord car = new CarRecord(
                request.getCompany(),
                request.getCarModel()
        );
        repository.save(car);
        return recordToCar.apply(car);
    }

    @Override
    public String vehicleType() {
        return "car";
    }
}
