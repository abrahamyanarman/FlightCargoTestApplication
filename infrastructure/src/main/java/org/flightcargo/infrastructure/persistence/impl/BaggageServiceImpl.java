package org.flightcargo.infrastructure.persistence.impl;

import lombok.AllArgsConstructor;
import org.flightcargo.core.Baggage;
import org.flightcargo.core.ports.BaggageRepositoryService;
import org.flightcargo.infrastructure.persistence.converters.BaggageRepositoryConverter;
import org.flightcargo.infrastructure.persistence.repositories.BaggageRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BaggageServiceImpl implements BaggageRepositoryService {

    private final BaggageRepository baggageRepository;
    private final BaggageRepositoryConverter baggageRepositoryConverter;

    @Override
    public Collection<Baggage> getBaggageByFlight(Long flightId) {
        return baggageRepository.getByFlight_FlightId(flightId).stream().map(baggageRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public void addBaggage(Baggage baggage) {
        baggageRepository.save(baggageRepositoryConverter.mapToTable(baggage));
    }

    @Override
    public void removeBaggage(Baggage baggage) {
        baggageRepository.delete(baggageRepositoryConverter.mapToTable(baggage));
    }

    @Override
    public Baggage updateBaggage(Baggage baggage) {
        return baggageRepositoryConverter.mapToEntity(baggageRepository.save(baggageRepositoryConverter.mapToTable(baggage)));
    }
}
