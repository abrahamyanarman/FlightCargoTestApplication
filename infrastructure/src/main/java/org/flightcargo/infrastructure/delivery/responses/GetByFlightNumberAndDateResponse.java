package org.flightcargo.infrastructure.delivery.responses;

public class GetByFlightNumberAndDateResponse extends Response {

    Long cargoWeight;
    Long baggageWeight;
    Long totalWeight;

    public GetByFlightNumberAndDateResponse() {
    }

    public GetByFlightNumberAndDateResponse(String status, String code, String message, Long cargoWeight, Long baggageWeight, Long totalWeight) {
        super(status, code, message);
        this.cargoWeight = cargoWeight;
        this.baggageWeight = baggageWeight;
        this.totalWeight = totalWeight;
    }
}
