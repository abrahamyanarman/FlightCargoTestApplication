package org.flightcargo.infrastructure.shared;

import java.io.Serializable;

public interface RestConverter<A extends Serializable, B extends Serializable> {

    default B mapToEntity(final A rest) {
        throw new UnsupportedOperationException();
    }

    default A mapToRest(final B entity) {
        throw new UnsupportedOperationException();
    }

}
