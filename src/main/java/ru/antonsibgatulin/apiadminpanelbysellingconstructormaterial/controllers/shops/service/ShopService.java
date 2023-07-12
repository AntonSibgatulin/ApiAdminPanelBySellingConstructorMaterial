package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops.respone.ShopGetSuccessRespone;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops.respone.ShopGetUnSeccessRespone;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.ShopDTO;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.shop.Shop;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.ShopRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.ObjectUtils;

import java.util.List;

@Service
public record ShopService(ShopRepository shopRepository) {

    public ResponseEntity getMyShops() {
        var admin = getAdmin();
        List<Shop> shopList = shopRepository.findAllByAdmin(admin);
        return ResponseEntity.ok(shopList);
    }


    public ResponseEntity getShopById(Long id) {
        var admin = getAdmin();
        var shop = shopRepository.getReferenceById(id);
        if(shop!=null && shop.getAdmin().getId() == admin.getId())
            return ResponseEntity.ok( new ShopGetSuccessRespone(shop));
        else
            return ResponseEntity.ok(new ShopGetUnSeccessRespone());
    }




    public Admin getAdmin(){
        return ObjectUtils.getAdmin();
    }

    public ResponseEntity createShop(ShopDTO shopDTO) {
        return null;
    }
}
