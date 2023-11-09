package ar.utn.edu.labiii.practicalabfinal.services;

import ar.utn.edu.labiii.practicalabfinal.dtos.carType.CarTypeRequestDto;
import ar.utn.edu.labiii.practicalabfinal.dtos.carType.CarTypeResponseDto;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CarTypeService {
    CarTypeResponseDto createCarType(CarTypeRequestDto carTypeRequestDto);
    CarTypeResponseDto getCarTypeById(Long id);
    List<CarTypeResponseDto> getCarTipes();
}
