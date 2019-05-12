package io.vehicle.repository.mapping;

import io.vehicle.api.Car;
import io.vehicle.repository.record.CarRecord;

import java.util.function.Function;

public class MapCarRecordToCar implements Function<CarRecord, Car> {

    @Override
    public Car apply (CarRecord carRecord){
       return new Car(
               carRecord.getId(),
               carRecord.getName(),
               carRecord.getCarModel()
       );
    }
}
