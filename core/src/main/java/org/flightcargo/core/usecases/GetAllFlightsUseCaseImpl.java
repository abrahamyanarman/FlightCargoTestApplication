package org.flightcargo.core.usecases;

import lombok.AllArgsConstructor;
import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightNotFoundException;
import org.flightcargo.core.ports.FlightRepositoryService;

import java.util.Collection;

@AllArgsConstructor
public class GetAllFlightsUseCaseImpl implements GetAllFlightsUseCase {

    private final FlightRepositoryService flightRepositoryService;

    @Override
    public Collection<Flight> execute() throws FlightNotFoundException {
        Collection<Flight> flights = flightRepositoryService.getAllFlights();
        if (flights.isEmpty()) {
            throw new FlightNotFoundException();
        }
        return flights;
    }
}
