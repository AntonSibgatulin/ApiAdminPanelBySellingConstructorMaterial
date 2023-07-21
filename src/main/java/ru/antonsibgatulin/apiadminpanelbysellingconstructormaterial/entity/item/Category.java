package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.shop.Shop;

@Data
@NoArgsConstructor
@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToOne
    private Admin admin;

    @JsonIgnore
    @ManyToOne
    private Shop shop;
}
