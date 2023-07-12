package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.ItemDTO;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item.ShopItems;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.DtoConverter;

@SpringBootTest
class ApiAdminPanelBySellingConstructorMaterialApplicationTests {

    @Autowired
    private DtoConverter dtoConverter;


    @Test
    void fromDTOToEntity() {
        var itemDTO = new ItemDTO();
        itemDTO.setName("Name");
        itemDTO.setShopId(4L);
        var entity = dtoConverter.convertToEntity(itemDTO, ShopItems.class);
        System.out.println(entity.toString());
        assert entity!=null;
    }



}
