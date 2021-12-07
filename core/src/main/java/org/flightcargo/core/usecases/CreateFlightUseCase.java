package org.flightcargo.core.usecases;

import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightAlreadyExistsException;

public interface CreateFlightUseCase {
    void execute(Flight flight) throws FlightAlreadyExistsException;
}
