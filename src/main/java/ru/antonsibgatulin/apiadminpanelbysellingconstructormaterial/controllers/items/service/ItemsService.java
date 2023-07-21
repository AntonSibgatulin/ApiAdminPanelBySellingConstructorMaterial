package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.items.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.items.respone.ItemSuccessRespone;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.items.respone.ItemUnSuccessRespone;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.ItemDTO;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Role;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item.ShopItems;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.ItemRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.ShopRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.DtoConverter;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.ObjectUtils;

import javax.swing.text.html.parser.Entity;


@Service
public record ItemsService(ItemRepository itemRepository, DtoConverter dtoConverter, ShopRepository shopRepository) {


    public ResponseEntity create(ItemDTO itemDTO) {
        return getResponseEntity(itemDTO);
    }


    public Admin getAdmin() {
        return ObjectUtils.getAdmin();
    }

    public ResponseEntity edit(ItemDTO itemDTO) {
        return getResponseEntity(itemDTO);
    }

    private ResponseEntity getResponseEntity(ItemDTO itemDTO) {
        var admin = getAdmin();
        var item = dtoConverter.convertToEntity(itemDTO, ShopItems.class);
        if (itemDTO.getShopId() == -1L) return ResponseEntity.ok(new ItemUnSuccessRespone());
        var shop = shopRepository.getReferenceById(itemDTO.getShopId());

        if (shop == null) {
            return ResponseEntity.ok(new ItemUnSuccessRespone());
        }

        if (shop.getAdmin().getId() == admin.getId()) {
            item.setShopId(shop);
            itemRepository.save(item);

            return ResponseEntity.ok(new ItemSuccessRespone(item));
        } else {
            return ResponseEntity.ok(new ItemUnSuccessRespone());
        }
    }

    public ResponseEntity delete(Long id) {
        var admin = getAdmin();
        var item = itemRepository.getReferenceById(id);
        if (item != null && (item.getShopId().getAdmin().getId() == admin.getId() || admin.getRole() == Role.ADMIN)) {
            itemRepository.delete(item);
        }
        return ResponseEntity.ok(new ItemSuccessRespone());

    }

    public ResponseEntity getMyItems(Long id) {
        var admin = getAdmin();
        var shop = shopRepository.getReferenceById(id);
        if (shop.getAdmin().getId() == admin.getId()) {
            var list = itemRepository.findAllByShopId(shop);
            return ResponseEntity.ok(list);
        } else
            return ResponseEntity.ok(new ItemUnSuccessRespone());
    }
}
