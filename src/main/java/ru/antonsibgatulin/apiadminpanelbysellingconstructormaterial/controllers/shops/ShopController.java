package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops.service.ShopService;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.ShopDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;


    @GetMapping("/getMyShops")
    public ResponseEntity getMyShops(){
        return  shopService.getMyShops();
    }
    @GetMapping("/getShopById/{id}")
    public ResponseEntity getShopById(@PathVariable("id") Long id){
        return shopService.getShopById(id);
    }

    @PutMapping("/createShop")
    public ResponseEntity createShop(@Valid @RequestBody ShopDTO shopDTO){
        return shopService.createShop(shopDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        return shopService.delete(id);

    }


}
