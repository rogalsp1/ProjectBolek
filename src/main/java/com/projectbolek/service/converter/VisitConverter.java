package com.projectbolek.service.converter;

import com.projectbolek.domain.entity.VisitEntity;
import com.projectbolek.domain.model.dto.VisitDTO;
import com.projectbolek.domain.repository.PatientRepository;
import com.projectbolek.domain.repository.UserRepository;
import com.projectbolek.domain.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rogalsp1 on 05.06.16.
 */
@Component
public class VisitConverter implements EntityDTOConverter<VisitEntity,VisitDTO> {

    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public VisitEntity fromDTO(VisitDTO visitDTO) {
        Long visitId = visitDTO.getId();
        VisitEntity visitEntity = new VisitEntity();
        if(visitId == null)
            visitEntity = visitRepository.findOne(visitId);
        visitEntity.setNotes(visitDTO.getNotes());
        visitEntity.setUser(userRepository.findOne(visitDTO.getPersonel()));
        visitEntity.setPatient(patientRepository.findOne(visitDTO.getPatient()));
        visitEntity.setBeginDateTime(visitDTO.getBeginDateTime());
        visitEntity.setEndDateTime(visitDTO.getEndDateTime());
        return visitEntity;
    }

    @Override
    public VisitDTO fromEntity(VisitEntity visitEntity) {
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setId(visitEntity.getId());
        visitDTO.setNotes(visitEntity.getNotes());
        visitDTO.setPersonel(visitEntity.getUser().getId());
        visitDTO.setPersonelName(visitEntity.getUser().getFirstName()
                + " " + visitEntity.getUser().getLastName());
        visitDTO.setPatient(visitEntity.getPatient().getId());
        visitDTO.setPatientName(visitEntity.getPatient().getFirstName()
                + " " + visitEntity.getPatient().getLastName());
        visitDTO.setBeginDateTime(visitEntity.getBeginDateTime());
        visitDTO.setEndDateTime(visitEntity.getEndDateTime());
        return visitDTO;
    }
}
