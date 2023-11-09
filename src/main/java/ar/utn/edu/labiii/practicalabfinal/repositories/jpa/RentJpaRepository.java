package ar.utn.edu.labiii.practicalabfinal.repositories.jpa;

import ar.utn.edu.labiii.practicalabfinal.entities.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentJpaRepository extends JpaRepository<RentEntity, Long> {
}
