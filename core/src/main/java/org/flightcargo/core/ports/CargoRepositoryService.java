package org.flightcargo.core.ports;

import org.flightcargo.core.Baggage;
import org.flightcargo.core.Cargo;

import java.util.Collection;

public interface CargoRepositoryService {

    Collection<Cargo> getCargoByFlight(int flightId);

    void addCargo(Cargo cargo);

    void removeCargo(Cargo cargo);

    Baggage updateCargo(Cargo cargo);

}
