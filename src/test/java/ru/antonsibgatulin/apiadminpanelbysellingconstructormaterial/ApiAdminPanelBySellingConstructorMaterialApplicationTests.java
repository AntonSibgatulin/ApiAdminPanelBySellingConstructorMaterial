package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial;

import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto.ItemDTO;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Role;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.item.ShopItems;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.token.TokenAdmin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.AdminRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.TokenAdminRepository;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.DtoConverter;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils.JwtTokenUtil;

@SpringBootTest
class ApiAdminPanelBySellingConstructorMaterialApplicationTests {

    @Autowired
    private DtoConverter dtoConverter;
    @Autowired
    private TokenAdminRepository tokenAdminRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    void fromDTOToEntity() {
        var itemDTO = new ItemDTO();
        itemDTO.setName("Name");
        itemDTO.setShopId(4L);
        var entity = dtoConverter.convertToEntity(itemDTO, ShopItems.class);
        System.out.println(entity.toString());
        assert entity != null;
    }


    @Test
    void saveTokens() {
        var admin = new Admin();
        admin.setRole(Role.ADMIN);
        admin.setEmail("8987920@mail.ru");
        admin.setPassword("Dert869$$");
        adminRepository.save(admin);

        var token = new TokenAdmin(generateToken(admin),admin);
        tokenAdminRepository.save(token);
        System.out.println(token);

        token = new TokenAdmin(generateToken(admin),admin);
        tokenAdminRepository.save(token);
        System.out.println(token);


    }

    public String generateToken(Admin admin) {
        return jwtTokenUtil.generateToken(admin);
    }

}
