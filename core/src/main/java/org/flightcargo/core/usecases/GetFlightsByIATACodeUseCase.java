package org.flightcargo.core.usecases;

import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightNotFoundException;

import java.util.Collection;
import java.util.Date;

public interface GetFlightsByIATACodeUseCase {
    Collection<Flight> execute(String iataAirportCode, Date date) throws FlightNotFoundException;

}
