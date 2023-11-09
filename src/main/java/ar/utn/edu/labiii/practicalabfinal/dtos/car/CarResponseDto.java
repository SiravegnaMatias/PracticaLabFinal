package ar.utn.edu.labiii.practicalabfinal.dtos.car;

import ar.utn.edu.labiii.practicalabfinal.dtos.carType.CarTypeResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponseDto {
    private Long id;
    private CarTypeResponseDto carType;
    private String brand;
    private String model;
}
