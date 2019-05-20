package io.vehicle.repository;

import io.vehicle.api.Car;
import io.vehicle.api.request.CarRequest;
import io.vehicle.repository.record.CarRecord;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CarServiceTest {
    private CarRecordRepository carRecordRepository = Mockito.mock(CarRecordRepository.class);
    private CarService carService = new CarService(carRecordRepository);
    private Car car = new Car(1L, "BMW", "X6");

    @Test
    void should_create_car() {

        //given
        when(carRecordRepository.save(any())).thenAnswer((Answer<CarRecord>) invocation -> {
            Object[] args = invocation.getArguments();
            return (CarRecord) args[0];
        });
        //when
        Car newCar = carService.createVehicle(new CarRequest("BMW", "X6"));
        //then
        assertEquals(newCar, car);
    }

    @Test
    void should_get_type() {
        //when
        String type = carService.vehicleType();
        //then
        assertEquals("cars", type);
    }

    @Test
    void should_get_list_of_cars() {
        //when
        List<Car> cars = carService.getVehicles();
        cars.add(car);
        //then
        assertEquals(cars.get(0), car);
    }
}