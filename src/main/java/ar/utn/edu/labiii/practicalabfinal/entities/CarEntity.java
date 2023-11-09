package ar.utn.edu.labiii.practicalabfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Entity
    @Table(name = "cars")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class CarEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "CarType_id")
        private CarTypeEntity carType;

        @Column
        private String brand;
        @Column
        private String model;
    }
