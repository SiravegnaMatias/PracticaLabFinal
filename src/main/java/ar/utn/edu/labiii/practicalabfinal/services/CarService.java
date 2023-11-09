package ar.utn.edu.labiii.practicalabfinal.services;

import ar.utn.edu.labiii.practicalabfinal.dtos.car.CarRequestDto;
import ar.utn.edu.labiii.practicalabfinal.dtos.car.CarResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<CarResponseDto> getAllCars();
    CarResponseDto getCarById(Long id);
    CarResponseDto createCar(CarRequestDto carRequestDto);
    CarResponseDto updateCar(Long id, CarRequestDto carRequestDto);
    void deleteCar(Long id);
    Boolean getByModel(String model);
}
