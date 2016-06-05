package com.projectbolek.service.converter;

import com.projectbolek.domain.entity.UserEntity;
import com.projectbolek.domain.model.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by rogalsp1 on 05.06.16.
 */
@Slf4j
@Component
public class UserConverter implements EntityDTOConverter<UserEntity,UserDTO>{

    @Override
    public UserEntity fromDTO(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
        userEntity.setAdmin(userDTO.getAdmin());
        userEntity.setDoctor(userDTO.getDoctor());
        userEntity.setReceptionist(userDTO.getReceptionist());
        userEntity.setPassword(userDTO.getPassword());
        return userEntity;
    }

    @Override
    public UserDTO fromEntity(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());
        userDTO.setPhoneNumber(userEntity.getPhoneNumber());
        userDTO.setAdmin(userEntity.getAdmin());
        userDTO.setDoctor(userEntity.getDoctor());
        userDTO.setReceptionist(userEntity.getReceptionist());
        return userDTO;
    }
}
