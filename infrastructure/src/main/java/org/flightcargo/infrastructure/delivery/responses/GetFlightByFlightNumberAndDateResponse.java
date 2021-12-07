package org.flightcargo.infrastructure.delivery.responses;

public class GetFlightByFlightNumberAndDateResponse<T> extends Response{
    private T body;

    public GetFlightByFlightNumberAndDateResponse() {
    }

    public GetFlightByFlightNumberAndDateResponse(String status, String code, String message, T body) {
        super(status, code, message);
        this.body = body;
    }
}
