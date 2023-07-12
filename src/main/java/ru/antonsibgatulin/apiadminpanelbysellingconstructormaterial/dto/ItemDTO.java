package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.web.bind.annotation.Mapping;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.annotation.IgnoreMapping;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item.category.Category;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.shop.Shop;

@Data
public class ItemDTO {

    @IgnoreMapping
    private Long shopId;
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
