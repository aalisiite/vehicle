package io.vehicle.repository;

import io.vehicle.repository.record.BicycleRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.Assert.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BicycleRecordRepositoryTest {
    @Autowired
    BicycleRecordRepository bicycleRecordRepository;

    @Test
    void should_return_bicycle() {
        //given
        BicycleRecord bicycle = bicycleRecordRepository.save(new BicycleRecord("KTM", "123"));
        //when
        List<BicycleRecord> newBicycle = bicycleRecordRepository.findAll();
        //then
        assertTrue(newBicycle.contains(bicycle));
    }
}