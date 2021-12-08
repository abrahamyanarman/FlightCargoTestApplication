package org.flightcargo.core.usecases;

import lombok.AllArgsConstructor;
import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightNotFoundException;
import org.flightcargo.core.ports.FlightRepositoryService;

import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
public class GetFlightsByIATACodeUseCaseResponse implements GetFlightsByIATACodeUseCase {

    private final FlightRepositoryService flightRepositoryService;

    @Override
    public Collection<Flight> execute(String iataAirportCode, Date date) throws FlightNotFoundException {
        Collection<Flight> flights = flightRepositoryService.getFlightsByIATACode(iataAirportCode, date);

        if (flights.isEmpty()) {
            throw new FlightNotFoundException();
        }

        return flights;
    }
}
