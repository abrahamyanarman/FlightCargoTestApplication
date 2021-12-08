package org.flightcargo.infrastructure.shared;

import java.io.Serializable;

public interface RepositoryConverter<A extends Serializable, B extends Serializable> {

    default A mapToTable(final B persistenceObject) {
        throw new UnsupportedOperationException();
    }

    default B mapToEntity(final A tableObject) {
        throw new UnsupportedOperationException();
    }

}
