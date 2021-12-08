package org.flightcargo.infrastructure.delivery.impl;

import lombok.RequiredArgsConstructor;
import org.flightcargo.core.Baggage;
import org.flightcargo.core.Cargo;
import org.flightcargo.core.Flight;
import org.flightcargo.core.exception.FlightNotFoundException;
import org.flightcargo.core.usecases.GetAllFlightsUseCase;
import org.flightcargo.core.usecases.GetFlightByFlightNumberAndDateUseCase;
import org.flightcargo.core.usecases.GetFlightsByIATACodeUseCase;
import org.flightcargo.infrastructure.delivery.FlightController;
import org.flightcargo.infrastructure.delivery.converters.FlightRestConverter;
import org.flightcargo.infrastructure.delivery.responses.FlightResponse;
import org.flightcargo.infrastructure.delivery.responses.GetByFlightNumberAndDateResponse;
import org.flightcargo.infrastructure.delivery.responses.GetByIATACodeAndDateResponse;
import org.flightcargo.infrastructure.delivery.rest.FlightRest;
import org.flightcargo.infrastructure.shared.constants.RestConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.APPI_VERSION_1 + RestConstants.RESOURCE_FLIGHT)
@RequiredArgsConstructor
public class FlightControllerImpl implements FlightController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightControllerImpl.class);

    private final GetFlightByFlightNumberAndDateUseCase getFlightByFlightNumberAndDateUseCase;
    private final GetAllFlightsUseCase getAllFlightsUseCase;
    private final GetFlightsByIATACodeUseCase getFlightsByIATACodeUseCase;

    private final FlightRestConverter flightRestConverter;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"flightNumber", "date"})
    public GetByFlightNumberAndDateResponse getFlightByFlightNumberAndDate(@RequestParam int flightNumber, @RequestParam Date date) {
        try {
            FlightRest flight = flightRestConverter.mapToRest(getFlightByFlightNumberAndDateUseCase.execute(flightNumber, date));
            Long cargoWeight = flight.getCargo().stream().mapToLong(Cargo::getWeight).sum();
            Long baggageWeight = flight.getBaggage().stream().mapToLong(Baggage::getWeight).sum();
            return new GetByFlightNumberAndDateResponse("SUCCESS", String.valueOf(HttpStatus.OK), "DONE",
                    cargoWeight, baggageWeight, cargoWeight + baggageWeight);
        } catch (FlightNotFoundException e) {
            LOGGER.warn(String.format("Flight with number: %d for date: %s not exists", flightNumber, date.toString()));
            return new GetByFlightNumberAndDateResponse("FAILURE", String.valueOf(HttpStatus.NOT_FOUND),
                    String.format("Flight with number: %d for date: %s not found", flightNumber, date.toString()),
                    null, null, null);
        }
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"iataAirportCode", "date"})
    public GetByIATACodeAndDateResponse getFlightByIATAAirportCodeAndDate(@RequestParam String iataAirportCode, @RequestParam Date date) {
        try {
            List<Integer> numberOfDepartingFlights = new ArrayList<>();
            List<Integer> numberOfArrivingFlights = new ArrayList<>();
            Long totalNumberOfArrivingBaggagePieces = 0L;
            Long totalNumberOfDepartingBaggagePieces = 0L;

            for (Flight flightRest : getFlightsByIATACodeUseCase.execute(iataAirportCode, date)) {
                if (flightRest.getArrivalAirportIATACode().equals(iataAirportCode)) {
                    numberOfArrivingFlights.add(flightRest.getFlightNumber());
                    totalNumberOfArrivingBaggagePieces += flightRest.getBaggage().stream().mapToLong(Baggage::getPieces).sum();
                } else if (flightRest.getDepartureAirportIATACode().equals(iataAirportCode)) {
                    numberOfDepartingFlights.add(flightRest.getFlightNumber());
                    totalNumberOfDepartingBaggagePieces += flightRest.getBaggage().stream().mapToLong(Baggage::getPieces).sum();
                }


            }
            return new GetByIATACodeAndDateResponse("SUCCESS", String.valueOf(HttpStatus.OK), "DONE",
                    numberOfDepartingFlights, numberOfArrivingFlights, totalNumberOfArrivingBaggagePieces, totalNumberOfDepartingBaggagePieces);
        } catch (FlightNotFoundException e) {
            LOGGER.warn(String.format("Flights with IATA Airport code: %s for date: %s not exists", iataAirportCode, date.toString()));
            return new GetByIATACodeAndDateResponse("FAILURE", String.valueOf(HttpStatus.NOT_FOUND),
                    String.format("Flights with IATA Airport code: %s for date: %s not exists", iataAirportCode,
                            date.toString()), null, null,
                    null, null);
        }
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public FlightResponse<Collection<FlightRest>> getAllFlights() {
        try {
            List<FlightRest> flights = getAllFlightsUseCase.execute().stream().map(flightRestConverter::mapToRest).collect(Collectors.toList());
            return new FlightResponse<>("SUCCESS", String.valueOf(HttpStatus.OK), "DONE", flights);
        } catch (FlightNotFoundException e) {
            LOGGER.warn("Flight not found!");
            return new FlightResponse<>("SUCCESS", String.valueOf(HttpStatus.OK), "DONE", Collections.emptyList());
        }

    }
}
