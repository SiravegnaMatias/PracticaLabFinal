package ar.utn.edu.labiii.practicalabfinal.dtos.rent;

import ar.utn.edu.labiii.practicalabfinal.dtos.car.CarResponseDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentResponseDto {
    private Long id;
    private String customer;
    private CarResponseDto car;
    private  Integer rentedDays;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime startRent;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime endRent;
    private BigDecimal totalPrice;
}
