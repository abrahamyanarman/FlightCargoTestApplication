package org.flightcargo.infrastructure.persistence.converters;

import org.flightcargo.core.Baggage;
import org.flightcargo.infrastructure.persistence.entities.BaggageEntity;
import org.flightcargo.infrastructure.shared.RepositoryConverter;
import org.flightcargo.infrastructure.shared.WeightUnit;

public class BaggageRepositoryConverter implements RepositoryConverter<BaggageEntity, Baggage> {

    private final FlightRepositoryConverter flightRepositoryConverter = new FlightRepositoryConverter();

    @Override
    public BaggageEntity mapToTable(Baggage persistenceObject) {
        return new BaggageEntity(persistenceObject.getId(), persistenceObject.getWeight(),
                WeightUnit.valueOf(persistenceObject.getWeightUnit()), persistenceObject.getPieces(),
                flightRepositoryConverter.mapToTable(persistenceObject.getFlight()));
    }

    @Override
    public Baggage mapToEntity(BaggageEntity tableObject) {
        return new Baggage(tableObject.getId(), tableObject.getWeight(), tableObject.getWeightUnit().name(),
                tableObject.getPieces(), flightRepositoryConverter.mapToEntity(tableObject.getFlight()));
    }
}
