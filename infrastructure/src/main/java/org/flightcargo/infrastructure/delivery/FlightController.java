package org.flightcargo.infrastructure.delivery;

import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightNotFoundException;
import org.flightcargo.infrastructure.delivery.responses.GetFlightByFlightNumberAndDateResponse;
import org.flightcargo.infrastructure.delivery.rest.FlightRest;

import java.util.Collection;
import java.util.Date;

public interface FlightController {

    GetFlightByFlightNumberAndDateResponse<FlightRest> getFlightByFlightNumberAndDate(int flightNumber, Date date) throws FlightNotFoundException;

    GetFlightByFlightNumberAndDateResponse<Collection<Flight>> getAllFlights();
}
