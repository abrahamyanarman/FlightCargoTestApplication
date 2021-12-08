package org.flightcargo.infrastructure.persistence.converters;

import org.flightcargo.core.Cargo;
import org.flightcargo.infrastructure.persistence.entities.CargoEntity;
import org.flightcargo.infrastructure.shared.RepositoryConverter;
import org.flightcargo.infrastructure.shared.WeightUnit;

public class CargoRepositoryConverter implements RepositoryConverter<CargoEntity, Cargo> {

    private final FlightRepositoryConverter flightRepositoryConverter = new FlightRepositoryConverter();

    @Override
    public CargoEntity mapToTable(Cargo persistenceObject) {
        return new CargoEntity(persistenceObject.getId(), persistenceObject.getWeight(),
                WeightUnit.valueOf(persistenceObject.getWeightUnit()), persistenceObject.getPieces(),
                flightRepositoryConverter.mapToTable(persistenceObject.getFlight()));
    }

    @Override
    public Cargo mapToEntity(CargoEntity tableObject) {
        return new Cargo(tableObject.getId(), tableObject.getWeight(), tableObject.getWeightUnit().name(),
                tableObject.getPieces(), flightRepositoryConverter.mapToEntity(tableObject.getFlight()));
    }
}
