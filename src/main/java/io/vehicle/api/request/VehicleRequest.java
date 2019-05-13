package io.vehicle.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.validation.constraints.NotEmpty;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarRequest.class, name = "car"),
        @JsonSubTypes.Type(value = BicycleRequest.class, name = "bicycle")
})
public abstract class VehicleRequest {

    @NotEmpty
    private String name;

    @JsonCreator
    VehicleRequest(@JsonProperty("name") @NotEmpty String name) {
        this.name = name;
    }

    public abstract String type();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
