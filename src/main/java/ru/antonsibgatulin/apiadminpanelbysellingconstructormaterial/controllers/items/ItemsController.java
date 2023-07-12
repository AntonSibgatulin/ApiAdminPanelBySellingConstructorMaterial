package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.items;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.items.service.ItemsService;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.ItemDTO;

@RequiredArgsConstructor
@RequestMapping("/items")
@RestController
public class ItemsController {

    private final ItemsService itemsService;

    @PutMapping("/create")
    public ResponseEntity create(@Valid @RequestBody ItemDTO itemDTO){
        return itemsService.create(itemDTO);
    }
}
