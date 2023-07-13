package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.items.respone;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ItemSuccessRespone {
    public String message = "OK";
    public Integer code = 200;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Object object;
    public <T> ItemSuccessRespone(T t){
        this.object = t;
    }
    public ItemSuccessRespone(){

    }
}
