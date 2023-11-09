package ar.utn.edu.labiii.practicalabfinal.services.impl;


import ar.utn.edu.labiii.practicalabfinal.dtos.carType.CarTypeRequestDto;
import ar.utn.edu.labiii.practicalabfinal.dtos.carType.CarTypeResponseDto;
import ar.utn.edu.labiii.practicalabfinal.entities.CarTypeEntity;
import ar.utn.edu.labiii.practicalabfinal.repositories.jpa.CarTypeJpaRepository;
import ar.utn.edu.labiii.practicalabfinal.services.CarTypeService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarTypeServiceImpl implements CarTypeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CarTypeJpaRepository carTypeJpaRepository;

    @Override
    public CarTypeResponseDto createCarType(CarTypeRequestDto carTypeRequestDto) {
        CarTypeEntity carTypeEntity = carTypeJpaRepository.save(modelMapper.map(carTypeRequestDto, CarTypeEntity.class));
        return modelMapper.map(carTypeEntity,CarTypeResponseDto.class);
    }

    @Override
    public CarTypeResponseDto getCarTypeById(Long id) {
        Optional<CarTypeEntity> carTypeOptional = carTypeJpaRepository.findById(id);
        if (carTypeOptional.isEmpty()) {
            throw new EntityNotFoundException("El tipo de auto no existe");
        }

        CarTypeEntity carTypeEntity = carTypeOptional.get();
        return  modelMapper.map(carTypeEntity, CarTypeResponseDto.class);
    }

    @Override
    public List<CarTypeResponseDto> getCarTipes() {
        List<CarTypeEntity> carEntities = carTypeJpaRepository.findAll();
        List<CarTypeResponseDto> carList = new ArrayList<>();

        for (CarTypeEntity car : carEntities) {
            carList.add(modelMapper.map(car, CarTypeResponseDto.class));
        }

        return carList;
    }
}
