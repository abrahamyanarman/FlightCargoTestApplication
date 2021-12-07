package org.flightcargo.infrastructure.shared;

public enum WeightUnit {
    KG("kg"), LB("lb");

    private String value;

    WeightUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
