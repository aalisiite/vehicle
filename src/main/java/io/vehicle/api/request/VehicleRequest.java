package io.vehicle.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VehicleRequest {
    @NotNull
    private Long id;
    @NotEmpty
    private String name;

    @JsonCreator
    public VehicleRequest(@JsonProperty("id") @NotNull Long id,
                          @JsonProperty("name") @NotEmpty String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
