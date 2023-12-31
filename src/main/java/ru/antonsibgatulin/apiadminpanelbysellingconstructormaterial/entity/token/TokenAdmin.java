package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.token;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;

@Data
@NoArgsConstructor
@Entity
public class TokenAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;


    @ManyToOne
    private Admin admin;


    public TokenAdmin(String token,Admin admin){
        this.token = token;
        this.admin = admin;
    }
}
