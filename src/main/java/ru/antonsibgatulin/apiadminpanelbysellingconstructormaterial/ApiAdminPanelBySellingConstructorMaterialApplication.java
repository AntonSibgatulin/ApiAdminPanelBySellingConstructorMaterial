package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Role;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.repository.AdminRepository;

@SpringBootApplication
public class ApiAdminPanelBySellingConstructorMaterialApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAdminPanelBySellingConstructorMaterialApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner (AdminRepository adminRepository){
       return (args -> {
          /* var admin = new Admin();
           admin.setRole(Role.ADMIN);
           admin.setEmail("8987920@mail.ru");
           admin.setPassword("Dert869$$");
           adminRepository.save(admin);

           admin.setEmail("89879201@mail.ru");

           admin.setId(null);

           adminRepository.save(admin);

           */
       }) ;
    };

}
