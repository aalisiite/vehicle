package io.vehicle.repository;

import io.vehicle.api.Bicycle;
import io.vehicle.api.request.BicycleRequest;
import io.vehicle.repository.record.BicycleRecord;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BicycleServiceTest {

    private BicycleRecordRepository bicycleRecordRepository = mock(BicycleRecordRepository.class);
    private BicycleService bicycleService = new BicycleService(bicycleRecordRepository);
    private Bicycle bicycle = new Bicycle(1L, "KTM", "123");


    @Test
    public void should_create_bicycle() {
        //given
        when(bicycleRecordRepository.save(any())).thenAnswer((Answer<BicycleRecord>) invocation -> {
            Object[] args = invocation.getArguments();
            return (BicycleRecord) args[0];
        });
        //when
        Bicycle newBicycle = bicycleService.createVehicle(new BicycleRequest("KTM", "123"));
        //then
        assertEquals(newBicycle, bicycle);
    }

    @Test
    public void should_get_type() {
        //when
        String type = bicycleService.vehicleType();
        //then
        assertEquals("bicycles", type);
    }

    @Test
    public void should_get_list_of_bicycles() {
        //when
        List<Bicycle> bicycles = bicycleService.getVehicles();
        bicycles.add(bicycle);
        //then
        assertEquals(bicycles.get(0), bicycle);
    }
}