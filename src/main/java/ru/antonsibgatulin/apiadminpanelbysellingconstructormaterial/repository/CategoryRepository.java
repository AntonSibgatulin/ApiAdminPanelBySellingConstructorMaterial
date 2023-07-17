package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
