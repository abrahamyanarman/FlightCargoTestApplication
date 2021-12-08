package org.flightcargo.infrastructure.delivery.converters;

import org.flightcargo.core.Baggage;
import org.flightcargo.infrastructure.delivery.rest.BaggageRest;
import org.flightcargo.infrastructure.shared.RestConverter;

public class BaggageRestConverter implements RestConverter<BaggageRest, Baggage> {

    private final FlightRestConverter flightRestConverter = new FlightRestConverter();

    @Override
    public Baggage mapToEntity(BaggageRest rest) {
        return new Baggage(rest.getId(), rest.getWeight(), rest.getWeightUnit(), rest.getPieces(), flightRestConverter.mapToEntity(rest.getFlight()));
    }

    @Override
    public BaggageRest mapToRest(Baggage entity) {
        return new BaggageRest(entity.getId(), entity.getWeight(), entity.getWeightUnit(), entity.getPieces(), flightRestConverter.mapToRest(entity.getFlight()));
    }
}
