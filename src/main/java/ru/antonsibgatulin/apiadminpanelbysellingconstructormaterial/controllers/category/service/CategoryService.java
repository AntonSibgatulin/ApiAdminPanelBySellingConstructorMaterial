package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.category.service;

import lombok.ToString;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.category.response.CategoryResponseError;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.category.response.CategoryResponseOK;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.CategoryDTO;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Role;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item.Category;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.shop.Shop;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.CategoryRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.ShopRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.DtoConverter;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.ObjectUtils;


@Service
public record CategoryService(CategoryRepository categoryRepository,
                              DtoConverter dtoConverter,
                              ShopRepository shopRepository) {


    public ResponseEntity create(CategoryDTO categoryDTO) {
        var admin = getAdmin();
        var shop = getShopById(categoryDTO);
        if(shop==null || shop.getAdmin().getId()!= admin.getId() || admin.getRole()!=Role.ADMIN){
            return ResponseEntity.ok(new CategoryResponseError());
        }
        var category = getConvertToEntity(categoryDTO);
        category.setAdmin(admin);
        category.setShop(shop);
        categoryRepository.save(category);
        return ResponseEntity.ok(category);
    }



    public ResponseEntity edit(CategoryDTO categoryDTO, Long id) {
        var admin = getAdmin();
        var categoryDB = categoryRepository.getReferenceById(id);
        if(categoryDB == null || categoryDB.getAdmin().getRole() != Role.ADMIN || categoryDB.getAdmin().getId()!=admin.getId()){
            return ResponseEntity.ok(new CategoryResponseError());
        }
        var category = getConvertToEntity(categoryDTO);
        category.setId(id);
        category.setShop(categoryDB.getShop());
        category.setAdmin(admin);
        categoryRepository.save(category);
        return ResponseEntity.ok(new CategoryResponseOK(category));
    }

    public ResponseEntity delete(Long id) {
        var admin = getAdmin();
        var categoryDB = categoryRepository.getReferenceById(id);
        if(categoryDB == null || categoryDB.getAdmin().getRole() != Role.ADMIN || categoryDB.getAdmin().getId()!=admin.getId()){
            return ResponseEntity.ok(new CategoryResponseError());
        }
        categoryRepository.delete(categoryDB);
        return ResponseEntity.ok(new CategoryResponseOK());

    }





    ////////////////////////////////////////////////////////////////////////
    private Shop getShopById(CategoryDTO categoryDTO) {
        return shopRepository.getReferenceById(categoryDTO.shop_id);
    }

    private Category getConvertToEntity(CategoryDTO categoryDTO) {
        return dtoConverter.convertToEntity(categoryDTO, Category.class);
    }


    private Admin getAdmin() {
        return ObjectUtils.getAdmin();
    }
}
