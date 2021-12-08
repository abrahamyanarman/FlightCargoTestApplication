package org.flightcargo.infrastructure.delivery;

import org.flightcargo.core.exception.FlightNotFoundException;
import org.flightcargo.infrastructure.delivery.responses.FlightResponse;
import org.flightcargo.infrastructure.delivery.responses.GetByFlightNumberAndDateResponse;
import org.flightcargo.infrastructure.delivery.responses.GetByIATACodeAndDateResponse;
import org.flightcargo.infrastructure.delivery.rest.FlightRest;

import java.util.Collection;
import java.util.Date;

public interface FlightController {

    GetByFlightNumberAndDateResponse getFlightByFlightNumberAndDate(int flightNumber, Date date) throws FlightNotFoundException;

    GetByIATACodeAndDateResponse getFlightByIATAAirportCodeAndDate(String iataAirportCode, Date date) throws FlightNotFoundException;

    FlightResponse<Collection<FlightRest>> getAllFlights();
}
