package org.flightcargo.infrastructure.delivery.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoRest implements Serializable {

    private static final long serialVersionUID = 7849555466145997443L;

    @Min(0)
    private Long id;

    @Min(0)
    @Max(999)
    private int weight;

    @NotEmpty
    private String weightUnit;

    @NotEmpty
    private int pieces;

    private FlightRest flight;

}
