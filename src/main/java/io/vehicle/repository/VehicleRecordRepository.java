package io.vehicle.repository;

import io.vehicle.repository.record.VehicleRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRecordRepository extends JpaRepository<VehicleRecord, Long> {
}
