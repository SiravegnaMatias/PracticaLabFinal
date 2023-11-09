package ar.utn.edu.labiii.practicalabfinal.services;

import ar.utn.edu.labiii.practicalabfinal.dtos.rent.RentRequestDto;
import ar.utn.edu.labiii.practicalabfinal.dtos.rent.RentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentService {
    RentResponseDto createRent(RentRequestDto rentRequestDto);
    RentResponseDto updateRent(Long id, RentRequestDto rentRequestDto);
    List<RentResponseDto> getAllRents();
    RentResponseDto getRentById(Long id);
    void deleteRent(Long id);
}
