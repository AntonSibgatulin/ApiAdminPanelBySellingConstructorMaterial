package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.category.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CategoryResponseOK {
    public String message = "OK";
    public Integer code = 200;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Object object;

    public CategoryResponseOK() {
    }

    public <T> CategoryResponseOK(T t){
        this.object = t;
    }


}
