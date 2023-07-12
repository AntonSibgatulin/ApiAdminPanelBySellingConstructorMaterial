package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.shop;


import jakarta.persistence.*;
import lombok.Data;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.coordinates.Coordinates;

import java.util.List;

@Data
@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable
    private List<Coordinates> coordinatesList;
    private String name;
    private String description;
    private String phone;
    private String workEmail;

    @OneToOne
    private Admin admin;

}
