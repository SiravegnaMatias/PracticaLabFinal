package ar.utn.edu.labiii.practicalabfinal.repositories.jpa;


import ar.utn.edu.labiii.practicalabfinal.entities.CarTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeJpaRepository extends JpaRepository<CarTypeEntity, Long> {
}
