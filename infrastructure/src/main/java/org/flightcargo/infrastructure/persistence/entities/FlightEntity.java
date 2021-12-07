package org.flightcargo.infrastructure.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.flightcargo.infrastructure.shared.ArrivalAirportIATACode;
import org.flightcargo.infrastructure.shared.DepartureAirportIATACode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FLIGHT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightEntity implements Serializable {

    private static final long serialVersionUID = 4563728195348318657L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightId;

    @Column(name = "FLIGHT_NUMBER")
    private int flightNumber;

    @Column(name = "DEPARTURE_AIRPORT_IATA_CODE")
    @Enumerated(EnumType.STRING)
    private DepartureAirportIATACode departureAirportIATACode;

    @Column(name = "ARRIVAL_AIRPORT_IATA_CODE")
    @Enumerated(EnumType.STRING)
    private ArrivalAirportIATACode arrivalAirportIATACode;

    @Column(name = "DEPARTURE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;

    @OneToMany(mappedBy = "flight")
    private List<BaggageEntity> baggage;

    @OneToMany(mappedBy = "flight")
    private List<CargoEntity> cargo;
}
