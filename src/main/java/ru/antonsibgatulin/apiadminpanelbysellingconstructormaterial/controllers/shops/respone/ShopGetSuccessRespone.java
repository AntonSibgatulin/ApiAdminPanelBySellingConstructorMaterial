package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.controllers.shops.respone;

public class ShopGetSuccessRespone {
    public String message = "OK";
    public Integer code = 200;
    public Object object;

    public <T> ShopGetSuccessRespone(T t) {
        this.object = t;
    }
}
