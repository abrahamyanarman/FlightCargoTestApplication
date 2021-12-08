package org.flightcargo.core.usecases;

import lombok.AllArgsConstructor;
import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightAlreadyExistsException;
import org.flightcargo.core.ports.FlightRepositoryService;

@AllArgsConstructor
public class CreateFlightUseCaseImpl implements CreateFlightUseCase {

    private final FlightRepositoryService flightRepositoryService;

    @Override
    public void execute(Flight flight) throws FlightAlreadyExistsException {

        if (flightRepositoryService.doesFlightAlreadyExists(flight)) {
            throw new FlightAlreadyExistsException();
        }

        flightRepositoryService.saveFlight(flight);
    }
}
