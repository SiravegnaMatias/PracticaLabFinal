package ar.utn.edu.labiii.practicalabfinal.controllers;

import ar.utn.edu.labiii.practicalabfinal.dtos.carType.CarTypeRequestDto;
import ar.utn.edu.labiii.practicalabfinal.dtos.carType.CarTypeResponseDto;
import ar.utn.edu.labiii.practicalabfinal.services.CarTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Car-type")
@CrossOrigin("http://localhost:4200")
public class CarTypeController {

    @Autowired
    private CarTypeService carTypeService;

    @PostMapping
    public ResponseEntity<CarTypeResponseDto> createCarType(@RequestBody CarTypeRequestDto carTypeRequestDto){
        return ResponseEntity.ok(carTypeService.createCarType(carTypeRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarTypeResponseDto> getCarTypeById(@PathVariable Long id){
        return  ResponseEntity.ok(carTypeService.getCarTypeById(id));
    }

   

    @GetMapping("/get-all")
    public ResponseEntity<List<CarTypeResponseDto>> getAll() {
        return ResponseEntity.ok(carTypeService.getCarTipes());
    }
}
