package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.shop.Shop;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,Long> {
    List<Shop> findAllByAdmin(Admin admin);
}
