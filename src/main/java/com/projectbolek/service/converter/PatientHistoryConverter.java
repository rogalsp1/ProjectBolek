package com.projectbolek.service.converter;

import com.projectbolek.domain.entity.PatientHistoryEntity;
import com.projectbolek.domain.model.dto.PatientHistoryDTO;
import com.projectbolek.domain.model.enums.SexEnum;
import com.projectbolek.domain.repository.PatientHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rogalsp1 on 04.06.16.
 */
@Component
@Slf4j
public class PatientHistoryConverter implements EntityDTOConverter<PatientHistoryEntity, PatientHistoryDTO>{

    @Autowired
    private PatientHistoryRepository PatientHistoryRepository;

    @Override
    public PatientHistoryEntity fromDTO(PatientHistoryDTO PatientHistoryDTO) {
       return null;
    }

    @Override
    public PatientHistoryDTO fromEntity(PatientHistoryEntity PatientHistoryEntity) {
        PatientHistoryDTO PatientHistoryDTO = new PatientHistoryDTO();
        PatientHistoryDTO.setId(PatientHistoryEntity.getId());
        PatientHistoryDTO.setDescription(PatientHistoryEntity.getDescription());
        PatientHistoryDTO.setDate(PatientHistoryEntity.getDate());
        PatientHistoryDTO.setPatient(PatientHistoryEntity.getPatient().getId());

        return PatientHistoryDTO;
    }
}
