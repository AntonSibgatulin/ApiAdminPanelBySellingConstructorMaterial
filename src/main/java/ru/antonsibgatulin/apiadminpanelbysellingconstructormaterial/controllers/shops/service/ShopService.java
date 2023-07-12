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
        if(shop!=null && shop.getAdmin().getId() == admin.getId())
            return ResponseEntity.ok( new ShopGetSuccessRespone(shop));
        else
            return ResponseEntity.ok(new ShopGetUnSeccessRespone());
    }






    public ResponseEntity createShop(ShopDTO shopDTO) {
        var admin = getAdmin();
        var shop = dtoConverter.convertToEntity(shopDTO,Shop.class);
        shopRepository.save(shop);

        return ResponseEntity.ok(shop);
    }

    public ResponseEntity delete(Long id) {
        var admin = getAdmin();
        var shop = shopRepository.getReferenceById(id);
        if(shop!=null && shop.getAdmin().getId() == admin.getId()){
            return ResponseEntity.ok(new DeleteResponseOK());
        }else{
            return ResponseEntity.ok(new DeleteResponseError());
        }
    }




    public Admin getAdmin(){
        return ObjectUtils.getAdmin();
    }
}
