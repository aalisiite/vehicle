package io.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.vehicle.repository.record.CarRecord;

public interface CarRecordRepository extends JpaRepository<CarRecord, String> {

}
