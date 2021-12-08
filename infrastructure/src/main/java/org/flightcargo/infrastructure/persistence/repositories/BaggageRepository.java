package org.flightcargo.infrastructure.persistence.repositories;

import org.flightcargo.infrastructure.persistence.entities.BaggageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BaggageRepository extends JpaRepository<BaggageEntity, Long> {

    Collection<BaggageEntity> getByFlight_FlightId(Long flightId);
}
