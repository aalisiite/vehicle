package io.vehicle.repository;

import io.vehicle.api.Car;
import io.vehicle.api.request.CarRequest;
import io.vehicle.repository.mapping.MapCarRecordToCar;
import io.vehicle.repository.record.CarRecord;
import org.springframework.stereotype.Component;
import io.vehicle.VehicleService;

import java.util.ArrayList;
import java.util.List;

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
                request.getModel()
        );
        repository.save(car);
        return recordToCar.apply(car);
    }

    @Override
    public String vehicleType() {
        return "cars";
    }

    @Override
    public List<Car> getVehicles() {

        List<CarRecord> cars = repository.findAll();
        List<Car> carList = new ArrayList<>();
        for (CarRecord carRecord : cars) {
            carList.add(recordToCar.apply(carRecord));
        }
        return carList;
    }
}
