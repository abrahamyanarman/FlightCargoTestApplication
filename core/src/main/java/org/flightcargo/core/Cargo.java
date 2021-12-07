package org.flightcargo.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.flightcargo.core.shared.SelfValidating;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class Cargo extends SelfValidating<Cargo> implements Serializable {

    @Min(0)
    private Long id;

    @Min(0)
    @Max(999)
    private int weight;

    @NotEmpty
    private String weightUnit;

    @NotEmpty
    private int pieces;
}
