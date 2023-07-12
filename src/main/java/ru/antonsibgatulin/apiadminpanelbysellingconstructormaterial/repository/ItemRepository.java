package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item.ShopItems;

public interface ItemRepository extends JpaRepository<ShopItems,Long> {
}
