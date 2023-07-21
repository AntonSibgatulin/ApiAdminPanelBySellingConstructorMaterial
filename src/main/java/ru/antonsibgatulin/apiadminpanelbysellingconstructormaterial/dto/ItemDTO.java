package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.annotation.IgnoreMapping;

@Data
public class ItemDTO {

    //private Long id;
    //@IgnoreMapping
    private Long shopId;
    private String name;
    private Integer price;

    private Integer pricePurchase;
    private Integer count;

    private String image;
    private String description;
    private Boolean discount;
    private Integer discount_percent;
    private Integer discount_price;
    private Long category_id;

}
