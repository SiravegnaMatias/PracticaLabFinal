package ar.utn.edu.labiii.practicalabfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Rents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String customer;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;
    @Column
    private  Integer rentedDays;
    @Column
    private LocalDateTime startRent;
    @Column
    private LocalDateTime endRent;
    @Column
    private BigDecimal totalPrice;
}
