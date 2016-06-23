package com.projectbolek.service.converter;

import com.projectbolek.domain.entity.ExaminationEntity;
import com.projectbolek.domain.entity.ServiceEntity;
import com.projectbolek.domain.entity.VisitEntity;
import com.projectbolek.domain.model.dto.ExaminationDTO;
import com.projectbolek.domain.repository.ServiceRepository;
import com.projectbolek.domain.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rogalsp1 on 23.06.16.
 */
@Component
public class ExaminationConverter implements EntityDTOConverter<ExaminationEntity, ExaminationDTO>{

    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ExaminationEntity fromDTO(ExaminationDTO examinationDTO) {
        ExaminationEntity examinationEntity = new ExaminationEntity();
        ServiceEntity service = serviceRepository.findOne(examinationDTO.getService());
        VisitEntity visit = visitRepository.findOne(examinationDTO.getId());
        examinationEntity.setService(service);
        examinationEntity.setServiceDate(examinationDTO.getServiceDate());
        examinationEntity.setVisit(visit);
        return examinationEntity;
    }

    @Override
    public ExaminationDTO fromEntity(ExaminationEntity examinationEntity) {
        ExaminationDTO examinationDTO = new ExaminationDTO();
        examinationDTO.setId(examinationEntity.getId());
        examinationDTO.setService(examinationEntity.getService().getId());
        examinationDTO.setVisit(examinationEntity.getVisit().getId());
        examinationDTO.setServiceDate(examinationEntity.getServiceDate());
        return examinationDTO;
    }
}
