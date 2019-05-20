package io.vehicle;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vehicle.api.request.BicycleRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


class VehicleControllerTest {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_get_201_when_vehicle_is_created() throws Exception {
        //given
        BicycleRequest bicycleRequest = new BicycleRequest("KTM", "123");
        String json = MAPPER.writeValueAsString(bicycleRequest);
        //when
        
        //except
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/create-vehicle")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
