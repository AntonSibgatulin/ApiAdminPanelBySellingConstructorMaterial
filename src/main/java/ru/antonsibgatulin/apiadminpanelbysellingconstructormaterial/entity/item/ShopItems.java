package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item;


import jakarta.persistence.*;
import lombok.Data;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item.category.Category;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.shop.Shop;

@Data
@Entity
public class ShopItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Shop shopId;
    private String name;
    private Integer price;
    private String image;
    private String description;
    private Boolean discount;
    private Integer discount_percent;
    private Integer discount_price;

    @Enumerated(EnumType.STRING)
    private Category category;
}
