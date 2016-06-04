package com.projectbolek.service.converter;

import com.projectbolek.domain.entity.PatientEntity;
import com.projectbolek.domain.model.dto.PatientDTO;
import com.projectbolek.domain.model.enums.SexEnum;
import com.projectbolek.domain.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rogalsp1 on 04.06.16.
 */
@Component
@Slf4j
public class PatientConverter implements EntityDTOConverter<PatientEntity, PatientDTO>{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientEntity fromDTO(PatientDTO patientDTO) {
        Long patientId = patientDTO.getId();
        PatientEntity patientEntity = new PatientEntity();
        if(patientId != null)
            patientEntity = patientRepository.findOne(patientId);
        patientEntity.setFirstName(patientDTO.getFirstName());
        patientEntity.setLastName(patientDTO.getLastName());
        patientEntity.setSex(SexEnum.valueOf(patientDTO.getSex()));
        patientEntity.setPesel(patientDTO.getPesel());
        patientEntity.setBirthdate(patientDTO.getBirthdate());
        patientEntity.setRegistrationDate(patientDTO.getRegistrationDate());
        patientEntity.setActive(patientDTO.getActive());
        return patientEntity;

    }

    @Override
    public PatientDTO fromEntity(PatientEntity patientEntity) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patientEntity.getId());
        patientDTO.setFirstName(patientEntity.getFirstName());
        patientDTO.setLastName(patientEntity.getLastName());
        patientDTO.setSex(patientEntity.getSex().toString());
        patientDTO.setPesel(patientEntity.getPesel());
        patientDTO.setBirthdate(patientEntity.getBirthdate());
        patientDTO.setActive(patientEntity.getActive());
        patientDTO.setRegistrationDate(patientEntity.getRegistrationDate());
        return patientDTO;
    }
}
