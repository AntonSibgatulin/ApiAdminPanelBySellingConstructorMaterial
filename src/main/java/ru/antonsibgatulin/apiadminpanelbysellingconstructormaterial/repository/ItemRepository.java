package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item.ShopItems;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.shop.Shop;

import java.util.List;

public interface ItemRepository extends JpaRepository<ShopItems,Long> {
    List<ShopItems> findAllByShopId(Shop shop);
}
