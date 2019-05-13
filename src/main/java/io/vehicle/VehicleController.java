package io.vehicle;

import io.vehicle.api.Bicycle;
import io.vehicle.api.request.BicycleRequest;
import io.vehicle.api.request.VehicleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Component
@RestController
@RequestMapping("/api")
public class VehicleController {

    private final List<VehicleService> services;

    public VehicleController(List<VehicleService> services) {
        this.services = services;
    }


    @PostMapping("/create-vehicle")
    public ResponseEntity<Bicycle> createBicycle(@RequestBody @Valid VehicleRequest request) {
        VehicleService service = services.stream()
                .filter(vehicleService -> vehicleService.vehicleType().equals(request.type()))
                .findFirst()
                .orElseThrow();
        service.createVehicle(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
