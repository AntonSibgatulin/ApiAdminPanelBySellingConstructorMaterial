package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.entity.admin.Admin;

public class ObjectUtils {

    public static Admin getAdmin() {
        Admin admin = (Admin) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return admin;
    }

}
