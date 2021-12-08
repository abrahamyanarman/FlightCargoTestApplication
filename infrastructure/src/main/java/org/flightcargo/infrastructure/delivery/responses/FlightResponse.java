package org.flightcargo.infrastructure.delivery.responses;

public class FlightResponse<T> extends Response {
    private T body;

    public FlightResponse() {
    }

    public FlightResponse(String status, String code, String message, T body) {
        super(status, code, message);
        this.body = body;
    }
}
