package org.flightcargo.infrastructure.delivery.converters;

import org.flightcargo.core.Flight;
import org.flightcargo.infrastructure.delivery.rest.FlightRest;
import org.flightcargo.infrastructure.shared.ArrivalAirportIATACode;
import org.flightcargo.infrastructure.shared.DepartureAirportIATACode;
import org.flightcargo.infrastructure.shared.RestConverter;

public class FlightRestConverter implements RestConverter<FlightRest, Flight> {
    @Override
    public Flight mapToEntity(FlightRest rest) {
        return new Flight(null, rest.getFlightNumber(), rest.getDepartureAirportIATACode().name(),
                rest.getArrivalAirportIATACode().name(), rest.getDepartureDate(), rest.getBaggage(), rest.getCargo());
    }

    @Override
    public FlightRest mapToRest(Flight entity) {
        return new FlightRest(entity.getFlightNumber(), DepartureAirportIATACode.valueOf(entity.getDepartureAirportIATACode()),
                ArrivalAirportIATACode.valueOf(entity.getArrivalAirportIATACode()), entity.getDepartureDate(),
                entity.getBaggage(), entity.getCargo());
    }
}
