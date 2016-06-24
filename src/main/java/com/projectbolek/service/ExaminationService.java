package com.projectbolek.service;

import com.projectbolek.domain.entity.ChargeEntity;
import com.projectbolek.domain.entity.ExaminationEntity;
import com.projectbolek.domain.repository.ChargeRepository;
import com.projectbolek.domain.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by rogalsp1 on 23.06.16.
 */
@Service
public class ExaminationService extends BaseService<ExaminationEntity> implements Serializable{

    private static final long serialVersionUID = 9064399702734391644L;

    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private ChargeRepository chargeRepository;

    public List<ExaminationEntity> findExaminationsByPatient(Long patientId) {
        return examinationRepository.findExaminationsByPatient(patientId);
    }

    public List<ExaminationEntity> findExaminationsByVisit(Long visitId) {
        return examinationRepository.findExaminationsByVisit(visitId);
    }

    @Transactional
    public void addNewExamination(ExaminationEntity examinationEntity) {
        ChargeEntity chargeEntity = new ChargeEntity();
        chargeEntity.setPatient(examinationEntity.getVisit().getPatient());
        chargeEntity.setExamination(examinationEntity);
        chargeEntity.setInvoiceDate(Timestamp.valueOf(LocalDateTime.now()));
        chargeEntity.setToPay(examinationEntity.getService().getPrice());
        examinationRepository.save(examinationEntity);
        chargeRepository.save(chargeEntity);
    }

    @Override
    public CrudRepository<ExaminationEntity, Long> getRepository() {
        return examinationRepository;
    }
}
