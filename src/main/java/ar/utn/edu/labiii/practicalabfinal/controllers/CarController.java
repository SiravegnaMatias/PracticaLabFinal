package ar.utn.edu.labiii.practicalabfinal.controllers;

import ar.utn.edu.labiii.practicalabfinal.dtos.car.CarRequestDto;
import ar.utn.edu.labiii.practicalabfinal.dtos.car.CarResponseDto;
import ar.utn.edu.labiii.practicalabfinal.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin("http://localhost:4200")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<CarResponseDto> createCar(@RequestBody CarRequestDto carRequestDto){
        return ResponseEntity.ok(carService.createCar(carRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDto> getCarById(@PathVariable Long id){
        return  ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/get-all-cars")
    public ResponseEntity<List<CarResponseDto>> getAllCars(){
        return  ResponseEntity.ok(carService.getAllCars());
    }

    @PutMapping("/{id}/edit-car")
    public ResponseEntity<CarResponseDto> updateCar(@PathVariable Long id, @RequestBody CarRequestDto carRequestDto){
        return ResponseEntity.ok(carService.updateCar(id, carRequestDto));
    }

    @DeleteMapping("/delete-car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-by-model")
    public ResponseEntity<Boolean> getCarByModel(String model) {
        return ResponseEntity.ok(carService.getByModel(model));
    }
}
