package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth.request.LoginRequest;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth.respone.LoginSuccessRespone;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth.respone.LoginUnSeccessRespone;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.token.TokenAdmin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.AdminRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.TokenAdminRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.JwtTokenUtil;

@Service
public record LoginService(TokenAdminRepository tokenAdminRepository, AdminRepository adminRepository,
                           JwtTokenUtil jwtTokenUtil) {

    public ResponseEntity login(LoginRequest loginRequest) {
        var admin = adminRepository.getAdminByEmailAndPassword(loginRequest.email, loginRequest.password);
        if (admin != null) {
            var tokenAdmin = new TokenAdmin(generateToken(admin), admin);
            tokenAdminRepository.save(tokenAdmin);
            return ResponseEntity.ok(new LoginSuccessRespone(tokenAdmin));
        } else
            return ResponseEntity.ok(new LoginUnSeccessRespone());
    }


    public String generateToken(Admin admin) {
        return jwtTokenUtil.generateToken(admin);
    }

}