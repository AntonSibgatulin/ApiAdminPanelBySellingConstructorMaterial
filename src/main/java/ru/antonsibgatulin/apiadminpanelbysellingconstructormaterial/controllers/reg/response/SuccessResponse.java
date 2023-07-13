package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.reg.response;

public class SuccessResponse {
    public String message = "OK";
    public Integer code = 200;
    public Object object;
    public <T> SuccessResponse(T t){
        this.object = t;
    }
}
