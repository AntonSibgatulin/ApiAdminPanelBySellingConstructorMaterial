package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.category.service.CategoryService;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.CategoryDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PutMapping("/create")
    public ResponseEntity create(@Valid @RequestBody CategoryDTO categoryDTO){
        return categoryService.create(categoryDTO);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity edit(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable("id") Long id){
        return categoryService.edit(categoryDTO,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        return categoryService.delete(id);
    }
}
