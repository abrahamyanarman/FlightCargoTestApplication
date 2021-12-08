package org.flightcargo.infrastructure.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.flightcargo.infrastructure.shared.WeightUnit;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CARGO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoEntity implements Serializable {

    private static final long serialVersionUID = 4566228265347311657L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "WEIGHT")
    private int weight;

    @Column(name = "WEIGHT_UNIT")
    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    @Column(name = "PIECES")
    private int pieces;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private FlightEntity flight;
}
