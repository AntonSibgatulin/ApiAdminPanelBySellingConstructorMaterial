package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.items;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.items.service.ItemsService;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.ItemDTO;

@RequiredArgsConstructor
@RequestMapping("api/items")
@RestController
public class ItemsController {

    private final ItemsService itemsService;

    @PutMapping("/create")
    public ResponseEntity create(@Valid @RequestBody ItemDTO itemDTO){
        return itemsService.create(itemDTO);
    }
    @PostMapping("/edit")
    public ResponseEntity edit(@Valid @RequestBody ItemDTO itemDTO){
        return itemsService.edit(itemDTO);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        return itemsService.delete(id);
    }
    @GetMapping("/getMyItems/{shop-id}")
    public ResponseEntity getMyItems(@PathVariable("shop-id") Long id){
        return itemsService.getMyItems(id);
    }

}
