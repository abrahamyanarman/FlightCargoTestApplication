package org.flightcargo.infrastructure.persistence.repositories;

import org.flightcargo.infrastructure.persistence.entities.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CargoRepository extends JpaRepository<CargoEntity, Long> {

    Collection<CargoEntity> getByFlight_FlightId(Long flightId);

}
