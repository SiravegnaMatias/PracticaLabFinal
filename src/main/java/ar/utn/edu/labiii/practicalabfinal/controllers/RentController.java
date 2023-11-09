package ar.utn.edu.labiii.practicalabfinal.controllers;

import ar.utn.edu.labiii.practicalabfinal.dtos.rent.RentRequestDto;
import ar.utn.edu.labiii.practicalabfinal.dtos.rent.RentResponseDto;
import ar.utn.edu.labiii.practicalabfinal.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController {
    @Autowired
    private RentService rentService;
    @PostMapping
    public ResponseEntity<RentResponseDto> createRent(@RequestBody RentRequestDto rentRequestDto){
        return ResponseEntity.ok(rentService.createRent(rentRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentResponseDto> getRentById(@PathVariable Long id){
        return  ResponseEntity.ok(rentService.getRentById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<RentResponseDto>> getAllRents(){
        return ResponseEntity.ok(rentService.getAllRents());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RentResponseDto> updateRent(@PathVariable Long id, @RequestBody RentRequestDto rentRequestDto){
        return ResponseEntity.ok(rentService.updateRent(id, rentRequestDto));
    }

    @DeleteMapping("/delete-car/{id}")
    public ResponseEntity<Void> deleteRent(@PathVariable Long id){
        rentService.deleteRent(id);
        return ResponseEntity.noContent().build();
    }
}
