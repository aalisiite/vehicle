package io.vehicle.repository;

import io.vehicle.repository.record.BicycleRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRecordRepository extends JpaRepository<BicycleRecord, Long> {

}
