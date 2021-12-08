package org.flightcargo.infrastructure.delivery.responses;

import java.util.List;

public class GetByIATACodeAndDateResponse extends Response {

    List<Integer> numberOfDepartingFlights;
    List<Integer> numberOfArrivingFlights;
    Long totalNumberOfArrivingBaggagePeaces;
    Long totalNumberOfDepartingBaggagePeaces;

    public GetByIATACodeAndDateResponse() {
    }

    public GetByIATACodeAndDateResponse(String status, String code, String message, List<Integer> numberOfDepartingFlights,
                                        List<Integer> numberOfArrivingFlights, Long totalNumberOfArrivingBaggagePeaces,
                                        Long totalNumberOfDepartingBaggagePeaces) {
        super(status, code, message);
        this.numberOfDepartingFlights = numberOfDepartingFlights;
        this.numberOfArrivingFlights = numberOfArrivingFlights;
        this.totalNumberOfArrivingBaggagePeaces = totalNumberOfArrivingBaggagePeaces;
        this.totalNumberOfDepartingBaggagePeaces = totalNumberOfDepartingBaggagePeaces;
    }
}
