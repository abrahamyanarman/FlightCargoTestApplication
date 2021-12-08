package org.flightcargo.infrastructure.persistence.repositories;

import org.flightcargo.infrastructure.persistence.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    FlightEntity getByFlightNumberAndDepartureDate(int flightNumber, Date departureDate);

    Collection<FlightEntity> getByArrivalAirportIATACodeOrDepartureAirportIATACodeAndAndDepartureDate(String iataCode, Date date);

    Collection<FlightEntity> getAll();

    boolean existsByFlightId(Long flightId);

}
