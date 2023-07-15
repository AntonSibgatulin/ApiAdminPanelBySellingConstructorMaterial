package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth.request.LoginRequest;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth.service.LoginService;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.token.TokenAdmin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.JwtTokenUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthenticationController {

    private final LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam("email")String email,@RequestParam("password") String password) {
        var loginRequest = new LoginRequest();
        loginRequest.email = email;
        loginRequest.password = password;

        return loginService.login(loginRequest);
    }



}
