package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.reg.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.reg.response.EmailAlreadyCreatedResponse;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.reg.response.InvalidDataResponse;

import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.reg.response.SuccessResponse;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.AdminDTO;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.AdminType;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Role;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.AdminRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.TokenAdminRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.DtoConverter;

@Service
public record RegService(AdminRepository adminRepository, TokenAdminRepository tokenAdminRepository,
                         DtoConverter dtoConverter) {

    public ResponseEntity reg(AdminDTO adminDTO) {
        var admin = dtoConverter.convertToEntity(adminDTO, Admin.class);
        admin.setRole(Role.SHOP_ADMIN);
        if (admin.getEmail() == null || admin.getPassword() == null) {
            return ResponseEntity.ok(new InvalidDataResponse());
        } else {
            var adminCheck = adminRepository.getAdminByEmail(adminDTO.email);
            if (adminCheck == null) {
                return ResponseEntity.ok(new EmailAlreadyCreatedResponse());
            }
            adminRepository.save(admin);
            return ResponseEntity.ok(new SuccessResponse(admin));
        }
    }

}