package ar.utn.edu.labiii.practicalabfinal.services.impl;

import ar.utn.edu.labiii.practicalabfinal.dtos.rent.RentRequestDto;
import ar.utn.edu.labiii.practicalabfinal.dtos.rent.RentResponseDto;
import ar.utn.edu.labiii.practicalabfinal.entities.RentEntity;
import ar.utn.edu.labiii.practicalabfinal.repositories.jpa.RentJpaRepository;
import ar.utn.edu.labiii.practicalabfinal.services.RentService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class RentServiceImpl  implements RentService {
    @Autowired
    private RentJpaRepository rentJpaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RentResponseDto createRent(RentRequestDto rentRequestDto) {
        RentEntity saved = rentJpaRepository.save(modelMapper.map(rentRequestDto, RentEntity.class));
        return  modelMapper.map(saved, RentResponseDto.class);
    }

    @Override
    public RentResponseDto updateRent(Long id, RentRequestDto rentRequestDto) {
        RentEntity rentEntity = rentJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("La renta no existe"));

        // Actualizar los campos de la entidad de renta con los valores del DTO
        rentEntity.setCustomer(rentRequestDto.getCustomer());
        rentEntity.setRentedDays(rentRequestDto.getRentedDays());
        rentEntity.setStartRent(rentRequestDto.getStartRent());
        rentEntity.setEndRent(rentRequestDto.getEndRent());
        rentEntity.setTotalPrice(rentRequestDto.getTotalPrice());
        // Actualizar otros campos según sea necesario

        RentEntity updatedRentEntity = rentJpaRepository.save(rentEntity);
        return modelMapper.map(updatedRentEntity, RentResponseDto.class);
    }

    @Override
    public List<RentResponseDto> getAllRents() {
        List<RentEntity> rentEntities = rentJpaRepository.findAll();
        List<RentResponseDto> rentResponseDtos = new ArrayList<>();

        for(RentEntity re : rentEntities){
            rentResponseDtos.add(modelMapper.map(re, RentResponseDto.class));
        }

        return rentResponseDtos;
    }

    @Override
    public RentResponseDto getRentById(Long id) {
        Optional<RentEntity> rentEntityOptional = rentJpaRepository.findById(id);
        if (rentEntityOptional.isEmpty()){
            throw new EntityNotFoundException("La renta no existe");
        }

        return modelMapper.map(rentEntityOptional.get(), RentResponseDto.class);
    }

    @Override
    public void deleteRent(Long id) {
        if (!rentJpaRepository.existsById(id)) {
            throw new EntityNotFoundException("La renta no existe");
        }
        rentJpaRepository.deleteById(id);
    }
}
