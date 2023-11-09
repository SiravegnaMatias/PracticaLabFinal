package ar.utn.edu.labiii.practicalabfinal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Long id;
    private CarType carType;
    private String brand;
    private String model;
}
