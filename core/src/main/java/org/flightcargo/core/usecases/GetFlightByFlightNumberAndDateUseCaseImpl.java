package org.flightcargo.core.usecases;

import lombok.AllArgsConstructor;
import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightNotFoundException;
import org.flightcargo.core.ports.FlightRepositoryService;

import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
public class GetFlightByFlightNumberAndDateUseCaseImpl implements GetFlightByFlightNumberAndDateUseCase{

    private final FlightRepositoryService flightRepositoryService;

    @Override
    public Flight execute(int flightNumber, Date date) throws FlightNotFoundException {
        Flight flight = flightRepositoryService.getFlightByFlightNumberAndDate(flightNumber, date);

        if (flight == null){
            throw new FlightNotFoundException();
        }

        return flight;
    }
}
