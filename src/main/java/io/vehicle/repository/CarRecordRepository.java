package io.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.vehicle.repository.record.CarRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRecordRepository extends JpaRepository<CarRecord, String> {

    @Query("select car from CarRecord car "
            + "where car.id =:id "
            + "and car.name =:name "
            + "and car.carModel =:carModel")
    List<CarRecord> findAllCars(@Param("id") Long id, @Param("name") String name, @Param("carModel") String carModel);
}