package org.flightcargo.infrastructure.delivery.impl;

import lombok.RequiredArgsConstructor;
import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightNotFoundException;
import org.flightcargo.core.usecases.GetFlightByFlightNumberAndDateUseCase;
import org.flightcargo.infrastructure.delivery.FlightController;
import org.flightcargo.infrastructure.delivery.converters.FlightRestConverter;
import org.flightcargo.infrastructure.delivery.responses.GetFlightByFlightNumberAndDateResponse;
import org.flightcargo.infrastructure.delivery.rest.FlightRest;
import org.flightcargo.infrastructure.shared.constants.RestConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.APPI_VERSION_1 + RestConstants.RESOURCE_FLIGHT)
@RequiredArgsConstructor
public class FlightControllerImpl implements FlightController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightControllerImpl.class);

    private final GetFlightByFlightNumberAndDateUseCase getFlightByFlightNumberAndDateUseCase;

    private final FlightRestConverter flightRestConverter;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public GetFlightByFlightNumberAndDateResponse<FlightRest> getFlightByFlightNumberAndDate(int flightNumber, Date date){
        try {
            Flight flight = getFlightByFlightNumberAndDateUseCase.execute(flightNumber, date);
            return new GetFlightByFlightNumberAndDateResponse<FlightRest>("SUCCESS", String.valueOf(HttpStatus.OK), "DONE", flightRestConverter.mapToRest(flight));
        } catch (FlightNotFoundException e) {
            LOGGER.warn(String.format("Flight with number: %d for date: %s not exists", flightNumber,date.toString()));
            return new GetFlightByFlightNumberAndDateResponse<FlightRest>("FAILURE", String.valueOf(HttpStatus.NOT_FOUND), String.format("Flight with number: %d for date: %s not found",flightNumber, date.toString()),null);
        }
    }

    @Override
    public GetFlightByFlightNumberAndDateResponse<Collection<Flight>> getAllFlights() {
        // not implemented yet!
        return null;
    }
}
