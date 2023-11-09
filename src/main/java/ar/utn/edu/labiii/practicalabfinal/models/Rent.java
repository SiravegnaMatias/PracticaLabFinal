package ar.utn.edu.labiii.practicalabfinal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rent {
    private Long id;
    private String customer;
    private Car car;
    private  Integer rentedDays;
    private LocalDateTime startRent;
    private LocalDateTime endRent;
    private BigDecimal totalPrice;
}
