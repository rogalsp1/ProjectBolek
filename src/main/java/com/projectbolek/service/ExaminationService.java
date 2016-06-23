package com.projectbolek.service;

import com.projectbolek.domain.entity.ExaminationEntity;
import com.projectbolek.domain.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rogalsp1 on 23.06.16.
 */
@Service
public class ExaminationService extends BaseService<ExaminationEntity> implements Serializable{

    private static final long serialVersionUID = 9064399702734391644L;

    @Autowired
    private ExaminationRepository examinationRepository;

    public List<ExaminationEntity> findExaminationsByPatient(Long patientId) {
        return examinationRepository.findExaminationsByPatient(patientId);
    }

    public List<ExaminationEntity> findExaminationsByVisit(Long visitId) {
        return examinationRepository.findExaminationsByVisit(visitId);
    }

    @Override
    public CrudRepository<ExaminationEntity, Long> getRepository() {
        return examinationRepository;
    }
}
