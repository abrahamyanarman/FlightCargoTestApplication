package org.flightcargo.infrastructure.delivery.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.flightcargo.core.Baggage;
import org.flightcargo.core.Cargo;
import org.flightcargo.infrastructure.shared.ArrivalAirportIATACode;
import org.flightcargo.infrastructure.shared.DepartureAirportIATACode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRest implements Serializable {

    private static final long serialVersionUID = 7809555366141998463L;

    @Min(1000)
    @Max(9999)
    private int flightNumber;

    @NotNull
    private DepartureAirportIATACode departureAirportIATACode;

    @NotNull
    private ArrivalAirportIATACode arrivalAirportIATACode;

    @NotNull
    private Date departureDate;

    private List<Baggage> baggage;

    private List<Cargo> cargo;
}
