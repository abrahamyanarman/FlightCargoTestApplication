package org.flightcargo.core.usecases;

import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightNotFoundException;

import java.util.Collection;

public interface GetAllFlightsUseCase {
    Collection<Flight> execute() throws FlightNotFoundException;
}
