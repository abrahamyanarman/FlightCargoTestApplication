package org.flightcargo.core.ports;

import org.flightcargo.core.Baggage;

import java.util.Collection;

public interface BaggageRepositoryService {

    Collection<Baggage> getBaggageByFlight(Long flightId);

    void addBaggage(Baggage baggage);

    void removeBaggage(Baggage baggage);

    Baggage updateBaggage(Baggage baggage);
}
