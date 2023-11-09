package ar.utn.edu.labiii.practicalabfinal.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestDto {
    private Long carTypeId;
    private String brand;
    private String model;
}
