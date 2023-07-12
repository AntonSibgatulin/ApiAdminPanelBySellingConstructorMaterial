package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.auth.respone;

public class LoginSuccessRespone {
    public String message = "AUTH_TRUE";
    public Integer code = 200;
    public Object object;
    public <T> LoginSuccessRespone(T t){
        this.object = t;
    }
}
