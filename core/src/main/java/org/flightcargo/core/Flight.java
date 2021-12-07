package org.flightcargo.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.flightcargo.core.shared.SelfValidating;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Flight extends SelfValidating<Flight> implements Serializable {

    @Min(0)
    private Long flightId;

    @Min(1000)
    @Max(9999)
    private int flightNumber;

    @NotEmpty
    private String departureAirportIATACode;

    @NotEmpty
    private String arrivalAirportIATACode;

    private Date departureDate;
    private List<Baggage> baggage;
    private List<Cargo> cargo;
}
