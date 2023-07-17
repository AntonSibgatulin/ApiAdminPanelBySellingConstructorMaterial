package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.shop;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.coordinates.Coordinates;

import java.util.List;

@Data
@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@OneToOne
    @JoinColumn
    private Coordinates address;

     */
    private String address;
    private String name;
    private String description;
    private String phone;
    private String workEmail;

    private Long timeCreate;
    private Long lastUpdate;
    private Integer profit;
    private Integer expenses; //затраты

    @ManyToOne
    private Admin admin;

}
