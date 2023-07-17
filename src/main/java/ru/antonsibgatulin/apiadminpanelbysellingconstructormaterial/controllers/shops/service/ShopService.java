package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops.respone.DeleteResponseError;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops.respone.DeleteResponseOK;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops.respone.ShopGetSuccessRespone;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops.respone.ShopGetUnSeccessRespone;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.ShopDTO;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Role;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.shop.Shop;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.ShopRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.DtoConverter;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.ObjectUtils;

import java.util.List;

@Service
public record ShopService(ShopRepository shopRepository, ModelMapper modelMapper,
                          DtoConverter dtoConverter) {


    public ResponseEntity getMyShops() {
        var admin = getAdmin();
        List<Shop> shopList = shopRepository.findAllByAdmin(admin);
        return ResponseEntity.ok(shopList);
    }


    public ResponseEntity getShopById(Long id) {
        var admin = getAdmin();
        var shop = shopRepository.getReferenceById(id);
        if (shop != null && shop.getAdmin().getId() == admin.getId())
            return ResponseEntity.ok(new ShopGetSuccessRespone(shop));
        else
            return ResponseEntity.ok(new ShopGetUnSeccessRespone());
    }


    public ResponseEntity createShop(ShopDTO shopDTO) {
        System.out.println(shopDTO.toString());
        var admin = getAdmin();
        var shop = dtoConverter.convertToEntity(shopDTO, Shop.class);
        shop.setTimeCreate(System.currentTimeMillis());
        shop.setLastUpdate(shop.getTimeCreate());
        shop.setProfit(0);
        shop.setExpenses(0);
        shop.setAdmin(admin);
        System.out.println(shop.toString());
        shopRepository.save(shop);

        return ResponseEntity.ok(shop);
    }

    public ResponseEntity delete(Long id) {
        var admin = getAdmin();
        var shop = shopRepository.getReferenceById(id);
        if (shop != null && (shop.getAdmin().getId() == admin.getId() || admin.getRole() == Role.ADMIN)) {
            shopRepository.delete(shop);
            return ResponseEntity.ok(new DeleteResponseOK());
        } else {
            return ResponseEntity.ok(new DeleteResponseError());
        }
    }


    public Admin getAdmin() {
        return ObjectUtils.getAdmin();
    }

    public ResponseEntity editShop(ShopDTO shopDTO, Long id) {
        var admin = getAdmin();
        var shopDabase = shopRepository.getReferenceById(id);
        if (shopDabase.getAdmin().getId() != admin.getId() || admin.getRole() != Role.ADMIN) {
            return ResponseEntity.ok(new ShopGetUnSeccessRespone());
        }
        var shop = dtoConverter.convertToEntity(shopDTO, Shop.class);
        shop.setId(id);
        shop.setTimeCreate(shopDabase.getTimeCreate());
        shop.setLastUpdate(shopDabase.getTimeCreate());
        shop.setProfit(shopDabase.getProfit());
        shop.setExpenses(shopDabase.getExpenses());
        shop.setAdmin(admin);
        shopRepository.save(shop);
        return ResponseEntity.ok(shop);
    }
}
