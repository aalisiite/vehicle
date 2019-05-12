package io.vehicle.repository.mapping;

import io.vehicle.api.Bicycle;
import io.vehicle.repository.record.BicycleRecord;

import java.util.function.Function;

public class MapBicycleRecordToBicycle implements Function<BicycleRecord, Bicycle> {

    @Override
    public Bicycle apply(BicycleRecord bicycleRecord) {
        return new Bicycle(
                bicycleRecord.getId(),
                bicycleRecord.getName(),
                bicycleRecord.getBicycleModel()
        );
    }
}
