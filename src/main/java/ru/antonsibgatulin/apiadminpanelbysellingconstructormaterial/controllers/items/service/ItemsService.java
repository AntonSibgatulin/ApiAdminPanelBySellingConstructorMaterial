package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.items.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.ItemDTO;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item.ShopItems;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.ItemRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.ShopRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.DtoConverter;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.ObjectUtils;


@Service
public record ItemsService(ItemRepository itemRepository, DtoConverter dtoConverter, ShopRepository shopRepository){


    public ResponseEntity create(ItemDTO itemDTO) {
        var admin = getAdmin();
        var item = dtoConverter.convertToEntity(itemDTO, ShopItems.class);
        var shop =shopRepository.getReferenceById(itemDTO.getShopId());
        itemRepository.save(item);

        return ResponseEntity.ok(item);
    };



    public Admin getAdmin(){
        return ObjectUtils.getAdmin();
    }

}
