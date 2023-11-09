package ar.utn.edu.labiii.practicalabfinal.dtos.carType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarTypeResponseDto {
    private Long id;
    private String type;
    private BigDecimal price;
}
