package ar.utn.edu.labiii.practicalabfinal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarType {
    private Long id;
    private String type;
    private BigDecimal price;
}
