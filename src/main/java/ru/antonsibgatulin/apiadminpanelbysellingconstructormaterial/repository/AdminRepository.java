package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> getAdminByEmail(String email);
    Admin getAdminByEmailAndPassword(String email,String password);
}
