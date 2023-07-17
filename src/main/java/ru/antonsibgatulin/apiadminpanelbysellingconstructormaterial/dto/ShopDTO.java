package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.dto;

import lombok.Data;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.coordinates.Coordinates;

import java.util.List;
@Data
public class ShopDTO {

    public String address;
    //public List<Coordinates> coordinatesList;
    public String name;
    public String description;
    public String phone;
    public String workEmail;

}
