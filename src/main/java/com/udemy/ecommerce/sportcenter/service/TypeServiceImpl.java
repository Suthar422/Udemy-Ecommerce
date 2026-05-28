package com.udemy.ecommerce.sportcenter.service;

import com.udemy.ecommerce.sportcenter.entity.Type;
import com.udemy.ecommerce.sportcenter.model.TypeResponse;
import com.udemy.ecommerce.sportcenter.repository.TypeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TypeServiceImpl implements TypeService{

    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    @Override
    public List<TypeResponse> getAllTypes() {
        log.info("Fetching All Types!!!");
        //fetching Types from DB
        List<Type> typeList= typeRepository.findAll();
        //now use stream operator to map with Response
        List<TypeResponse> typeResponses = typeList.stream()
                .map(this::convertToTypeResponse)
                .toList();

        log.info("Fetching All Types!!!");
        return typeResponses;
    }

    private TypeResponse convertToTypeResponse(Type type) {
        return TypeResponse.builder()
                .id(type.getId())
                .name(type.getName())
                .build();
    }
}
