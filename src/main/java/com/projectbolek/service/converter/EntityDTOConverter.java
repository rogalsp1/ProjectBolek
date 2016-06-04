package com.projectbolek.service.converter;

import com.projectbolek.domain.entity.BaseEntity;
import com.projectbolek.domain.model.dto.BaseDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rogalsp1 on 03.06.16.
 */
public interface EntityDTOConverter<T extends BaseEntity, S extends BaseDTO>{

    T fromDTO(S s);

    S fromEntity(T t);

    default List<T> fromDTO(List<S> sList){
        return sList.stream().map(this::fromDTO).collect(Collectors.toList());
    }

    default List<S> fromEntity(List<T> tList){
        return tList.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
