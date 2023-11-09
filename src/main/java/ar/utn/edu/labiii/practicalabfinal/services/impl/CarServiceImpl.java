package ar.utn.edu.labiii.practicalabfinal.services.impl;

import ar.utn.edu.labiii.practicalabfinal.dtos.car.CarRequestDto;
import ar.utn.edu.labiii.practicalabfinal.dtos.car.CarResponseDto;
import ar.utn.edu.labiii.practicalabfinal.entities.CarEntity;
import ar.utn.edu.labiii.practicalabfinal.repositories.jpa.CarJpaRepository;
import ar.utn.edu.labiii.practicalabfinal.services.CarService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CarServiceImpl implements CarService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CarJpaRepository carJpaRepository;
    
    @Override
    public List<CarResponseDto> getAllCars() {
        List<CarEntity> carEntityList = carJpaRepository.findAll();
        List<CarResponseDto> carResponseDtoList = new ArrayList<>();

        for(CarEntity car : carEntityList){
            carResponseDtoList.add(modelMapper.map(car, CarResponseDto.class));
        }

        return carResponseDtoList;
    }

    @Override
    public CarResponseDto getCarById(Long id) {
        Optional<CarEntity> carEntityOptional = carJpaRepository.findById(id);
        if(carEntityOptional.isEmpty()){
            throw  new EntityNotFoundException("El auto no existe");
        }

        return modelMapper.map(carEntityOptional.get(), CarResponseDto.class);
    }

    @Override
    public CarResponseDto createCar(CarRequestDto carRequestDto) {

        CarEntity carEntity = modelMapper.map(carRequestDto, CarEntity.class);
        CarEntity savedCarEntity = carJpaRepository.save(carEntity);
        return modelMapper.map(savedCarEntity, CarResponseDto.class);
    }

    @Override
    public CarResponseDto updateCar(Long id, CarRequestDto carRequestDto) {
        return null;
    }


    @Override
    public void deleteCar(Long id) {
        if (!carJpaRepository.existsById(id)) {
            throw new EntityNotFoundException("El auto no existe");
        }
        carJpaRepository.deleteById(id);
    }

    @Override
    public Boolean getByModel(String model) {
      List<CarEntity> lEntities = carJpaRepository.findByModel(model);
         return !lEntities.isEmpty();
    }
}
