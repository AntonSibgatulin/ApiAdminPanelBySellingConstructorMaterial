package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.items.respone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ItemSuccessRespone {
    public String message = "OK";
    public Integer code = 200;

    @JsonIgnore
    public Object object;
    public <T> ItemSuccessRespone(T t){
        this.object = t;
    }
    public ItemSuccessRespone(){

    }
}
