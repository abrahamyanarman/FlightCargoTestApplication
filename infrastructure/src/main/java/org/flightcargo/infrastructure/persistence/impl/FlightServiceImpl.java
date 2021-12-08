package org.flightcargo.infrastructure.persistence.impl;

import lombok.AllArgsConstructor;
import org.flightcargo.core.Flight;
import org.flightcargo.core.ports.FlightRepositoryService;
import org.flightcargo.infrastructure.persistence.converters.FlightRepositoryConverter;
import org.flightcargo.infrastructure.persistence.repositories.FlightRepository;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FlightServiceImpl implements FlightRepositoryService {

    private final FlightRepository flightRepository;
    private final FlightRepositoryConverter flightRepositoryConverter;

    @Override
    public Collection<Flight> getAllFlights() {
        return flightRepository.getAll().stream().map(flightRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public void saveFlight(Flight flight) {
        flightRepository.save(flightRepositoryConverter.mapToTable(flight));
    }

    @Override
    public Flight getFlightByFlightNumberAndDate(int flightNumber, Date date) {
        return flightRepositoryConverter.mapToEntity(flightRepository.getByFlightNumberAndDepartureDate(flightNumber, date));
    }

    @Override
    public Collection<Flight> getFlightsByIATACode(String iataAirportCode, Date date) {
        return flightRepository.getByArrivalAirportIATACodeOrDepartureAirportIATACodeAndAndDepartureDate(iataAirportCode, date)
                .stream().map(flightRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public void removeFlight(Flight flight) {
        flightRepository.delete(flightRepositoryConverter.mapToTable(flight));
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepositoryConverter.mapToEntity(flightRepository.save(flightRepositoryConverter.mapToTable(flight)));
    }

    @Override
    public boolean doesFlightAlreadyExists(Flight flight) {
        return !flightRepository.existsByFlightId(flight.getFlightId());
    }
}
