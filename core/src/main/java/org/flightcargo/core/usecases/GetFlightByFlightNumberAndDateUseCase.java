package org.flightcargo.core.usecases;

import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightNotFoundException;

import java.util.Date;

public interface GetFlightByFlightNumberAndDateUseCase {
    Flight execute(int flightNumber, Date date) throws FlightNotFoundException;
}
