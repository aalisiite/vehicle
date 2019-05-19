package io.vehicle.repository;

import io.vehicle.repository.record.BicycleRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BicycleRecordRepository extends JpaRepository<BicycleRecord, Long> {

    @Query("select bicycle from BicycleRecord bicycle"
            + " where bicycle.id = :id "
            + " and bicycle.company = :company "
            + "and bicycle.model =:model ")
    List<BicycleRecord> findAllBicycles(@Param("id") Long id, @Param("company") String company, @Param("model") String model);
}
