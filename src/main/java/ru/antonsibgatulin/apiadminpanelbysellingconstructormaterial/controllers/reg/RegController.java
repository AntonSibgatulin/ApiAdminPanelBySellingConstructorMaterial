package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.reg;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.reg.service.RegService;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.AdminDTO;

@RequiredArgsConstructor
@RequestMapping("api/reg")
@RestController
public class RegController {

    private final RegService regService;

    public ResponseEntity reg(@Valid @RequestBody AdminDTO adminDTO){
        return regService.reg(adminDTO);
    }

}
