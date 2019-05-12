package io.vehicle.repository;

import io.vehicle.repository.record.BicycleRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BicycleRecordRepository extends JpaRepository<BicycleRecord, Long> {

    @Query("select bicycle from BicycleRecord bicycle"
            + " where bicycle.id = :id "
            + " and bicycle.name = :name "
            + "and bicycle.bicycleModel =:bicycleModel ")
    List<BicycleRecord> findAllBicycles(@Param("id") Long id, @Param("name") String name, @Param("bicycleModel") String bicycleModel);
}
