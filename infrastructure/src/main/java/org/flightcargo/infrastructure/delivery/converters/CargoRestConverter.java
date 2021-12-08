package org.flightcargo.infrastructure.delivery.converters;

import org.flightcargo.core.Cargo;
import org.flightcargo.infrastructure.delivery.rest.CargoRest;
import org.flightcargo.infrastructure.shared.RestConverter;

public class CargoRestConverter implements RestConverter<CargoRest, Cargo> {

    private final FlightRestConverter flightRestConverter = new FlightRestConverter();

    @Override
    public Cargo mapToEntity(CargoRest rest) {
        return new Cargo(rest.getId(), rest.getWeight(), rest.getWeightUnit(), rest.getPieces(), flightRestConverter.mapToEntity(rest.getFlight()));
    }

    @Override
    public CargoRest mapToRest(Cargo entity) {
        return new CargoRest(entity.getId(), entity.getWeight(), entity.getWeightUnit(), entity.getPieces(), flightRestConverter.mapToRest(entity.getFlight()));
    }
}
