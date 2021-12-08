package org.flightcargo.core.ports;

import org.flightcargo.core.Baggage;
import org.flightcargo.core.Cargo;

import java.util.Collection;

public interface CargoRepositoryService {

    Collection<Cargo> getCargoByFlight(Long flightId);

    void addCargo(Cargo cargo);

    void removeCargo(Cargo cargo);

    Cargo updateCargo(Cargo cargo);

}
