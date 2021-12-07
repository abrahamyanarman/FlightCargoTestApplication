package org.flightcargo.core.ports;

import org.flightcargo.core.Flight;

import java.util.Collection;
import java.util.Date;

public interface FlightRepositoryService {
    Collection<Flight> getAllFlights();

    void saveFlight(Flight flight);

    Flight getFlightByFlightNumberAndDate(int flightNumber, Date date);

    void removeFlight(Flight flight);

    Flight updateFlight(Flight flight);

    boolean doesFlightAlreadyExists(Flight flight);
}
