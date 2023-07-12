package ru.antonsibgatulin.apiadminpanelbysellingconstructormaterial.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {

    private final ModelMapper modelMapper;

    public DtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T> T convertToEntity(Object dto, Class<T> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public <T> T convertToDto(Object entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
}
