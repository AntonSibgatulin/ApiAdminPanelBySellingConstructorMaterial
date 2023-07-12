package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.annotation.IgnoreMapping;

import java.lang.reflect.Field;

@Component
public class DtoConverter {

    private final ModelMapper modelMapper;

    public DtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T> T convertToEntity1(Object dto, Class<T> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public <T> T convertToDto(Object entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <T, U> U convertToEntity(T source, Class<U> destinationClass) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

/*
        PropertyMap<T, U> propertyMap = new PropertyMap<>() {
            protected void configure() {
                for (Field destinationField : destinationClass.getDeclaredFields()) {
                    IgnoreMapping ignoreMapping = destinationField.getAnnotation(IgnoreMapping.class);
                    if (ignoreMapping != null) {
                        skip();
                    }
                }
            }
        };

        modelMapper.addMappings(propertyMap);

 */



        return modelMapper.map(source, destinationClass);
    }


}
