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
    private String company;

    @JsonCreator
    VehicleRequest(@JsonProperty("company") @NotEmpty String company) {
        this.company = company;
    }

    public abstract String type();

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
