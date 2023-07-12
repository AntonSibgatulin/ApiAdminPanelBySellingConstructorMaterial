package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.coordinates;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coordinates")
public class Coordinates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long lat;
    private Long lon;
    private String address;
    private Long user_id;
}
