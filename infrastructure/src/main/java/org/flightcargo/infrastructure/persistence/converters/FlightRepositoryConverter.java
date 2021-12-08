package org.flightcargo.infrastructure.persistence.converters;

import org.flightcargo.core.Flight;
import org.flightcargo.infrastructure.persistence.entities.FlightEntity;
import org.flightcargo.infrastructure.shared.ArrivalAirportIATACode;
import org.flightcargo.infrastructure.shared.DepartureAirportIATACode;
import org.flightcargo.infrastructure.shared.RepositoryConverter;

import java.util.stream.Collectors;

public class FlightRepositoryConverter implements RepositoryConverter<FlightEntity, Flight> {

    private final BaggageRepositoryConverter baggageRepositoryConverter = new BaggageRepositoryConverter();
    private final CargoRepositoryConverter cargoRepositoryConverter = new CargoRepositoryConverter();

    @Override
    public FlightEntity mapToTable(final Flight persistenceObject) {
        return new FlightEntity(persistenceObject.getFlightId(), persistenceObject.getFlightNumber(),
                DepartureAirportIATACode.valueOf(persistenceObject.getDepartureAirportIATACode()),
                ArrivalAirportIATACode.valueOf(persistenceObject.getArrivalAirportIATACode()),
                persistenceObject.getDepartureDate(),
                persistenceObject.getBaggage().stream()
                        .map(baggageRepositoryConverter::mapToTable).collect(Collectors.toList()),
                persistenceObject.getCargo().stream()
                        .map(cargoRepositoryConverter::mapToTable).collect(Collectors.toList()));
    }

    @Override
    public Flight mapToEntity(FlightEntity tableObject) {
        return new Flight(tableObject.getFlightId(), tableObject.getFlightNumber(),
                tableObject.getDepartureAirportIATACode().name(), tableObject.getArrivalAirportIATACode().name(),
                tableObject.getDepartureDate(),
                tableObject.getBaggage().stream()
                        .map(baggageRepositoryConverter::mapToEntity).collect(Collectors.toList()),
                tableObject.getCargo().stream()
                        .map(cargoRepositoryConverter::mapToEntity).collect(Collectors.toList()));
    }

}
