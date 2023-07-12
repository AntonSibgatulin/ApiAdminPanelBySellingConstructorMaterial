package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth.request.LoginRequest;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth.service.LoginService;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.token.TokenAdmin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.JwtTokenUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final LoginService loginService;




    @GetMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }
}
