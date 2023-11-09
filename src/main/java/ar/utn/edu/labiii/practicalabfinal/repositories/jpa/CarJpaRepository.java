package ar.utn.edu.labiii.practicalabfinal.repositories.jpa;

import ar.utn.edu.labiii.practicalabfinal.entities.CarEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CarJpaRepository extends JpaRepository<CarEntity, Long> {
     List<CarEntity> findByModel(String model);
}
