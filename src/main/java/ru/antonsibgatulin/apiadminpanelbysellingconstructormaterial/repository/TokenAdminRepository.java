package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.token.TokenAdmin;

@Repository
public interface TokenAdminRepository extends JpaRepository<TokenAdmin, Long> {
    TokenAdmin getTokenAdminByToken(String token);
}
