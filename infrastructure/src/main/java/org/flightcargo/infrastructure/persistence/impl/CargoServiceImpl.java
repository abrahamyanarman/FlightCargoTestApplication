package org.flightcargo.infrastructure.persistence.impl;

import lombok.AllArgsConstructor;
import org.flightcargo.core.Cargo;
import org.flightcargo.core.ports.CargoRepositoryService;
import org.flightcargo.infrastructure.persistence.converters.CargoRepositoryConverter;
import org.flightcargo.infrastructure.persistence.repositories.CargoRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CargoServiceImpl implements CargoRepositoryService {

    private final CargoRepository cargoRepository;
    private final CargoRepositoryConverter cargoRepositoryConverter;

    @Override
    public Collection<Cargo> getCargoByFlight(Long flightId) {
        return cargoRepository.getByFlight_FlightId(flightId).stream().map(cargoRepositoryConverter::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public void addCargo(Cargo cargo) {
        cargoRepository.save(cargoRepositoryConverter.mapToTable(cargo));
    }

    @Override
    public void removeCargo(Cargo cargo) {
        cargoRepository.delete(cargoRepositoryConverter.mapToTable(cargo));
    }

    @Override
    public Cargo updateCargo(Cargo cargo) {
        return cargoRepositoryConverter.mapToEntity(cargoRepository.save(cargoRepositoryConverter.mapToTable(cargo)));
    }
}
