package io.vehicle.repository;

import io.vehicle.api.Bicycle;
import io.vehicle.api.request.BicycleRequest;
import io.vehicle.repository.mapping.MapBicycleRecordToBicycle;
import io.vehicle.repository.record.BicycleRecord;
import org.springframework.stereotype.Component;
import io.vehicle.VehicleService;

import java.util.ArrayList;
import java.util.List;

@Component
class BicycleService implements VehicleService<Bicycle, BicycleRequest> {

    private BicycleRecordRepository repository;
    private MapBicycleRecordToBicycle recordToBicycle = new MapBicycleRecordToBicycle();

    public BicycleService(BicycleRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bicycle createVehicle(BicycleRequest request) {
        BicycleRecord bicycle = new BicycleRecord(
                request.getCompany(),
                request.getModel()
        );
        bicycle = repository.save(bicycle);
        return recordToBicycle.apply(bicycle);
    }

    @Override
    public String vehicleType() {
        return "bicycles";
    }

    @Override
    public List<Bicycle> getVehicles() {
        List<BicycleRecord> bicycles = repository.findAll();
        List<Bicycle> bicycleList = new ArrayList<>();
        for (BicycleRecord bicycleRecord : bicycles) {
            bicycleList.add(recordToBicycle.apply(bicycleRecord));
        }
        return bicycleList;
    }
}
