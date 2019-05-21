package io.vehicle;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vehicle.api.Bicycle;
import io.vehicle.api.request.BicycleRequest;
import io.vehicle.repository.BicycleService;
import io.vehicle.repository.mapping.MapBicycleRecordToBicycle;
import io.vehicle.repository.record.BicycleRecord;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
class VehicleControllerTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BicycleService service;

    private MapBicycleRecordToBicycle bicycleRecordToBicycle = new MapBicycleRecordToBicycle();

    @Test
    void should_get_201_when_vehicle_is_created() throws Exception {
        //given
        Mockito.when(service.vehicleType()).thenReturn("bicycles");
        BicycleRequest bicycleRequest = new BicycleRequest("KTM", "123");
        String json = MAPPER.writeValueAsString(bicycleRequest);
        //except
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/create-vehicle")
                        .content(json)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void should_get_200_and_list_of_vehicles() throws Exception {
        //given

        Bicycle bicycle = new Bicycle(1L, "KTM", "123");
        Mockito.when(service.getVehicles()).thenReturn(Collections.singletonList(bicycle));
        Mockito.when(service.vehicleType()).thenReturn("bicycles");
        //except
        String response = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/vehicles?types=bicycles"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<Bicycle> bicycleList = MAPPER.readValue(response, new TypeReference<List<Bicycle>>() {
        });

        //then
        Assert.assertEquals(bicycleList, Collections.singletonList(bicycle));
    }

    public Bicycle getBicycleFromBicycleRecord(BicycleRecord record) {
        return bicycleRecordToBicycle.apply(record);
    }
}
