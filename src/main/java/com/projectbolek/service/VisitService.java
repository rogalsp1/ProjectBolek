package com.projectbolek.service;

import com.projectbolek.domain.entity.ChargeEntity;
import com.projectbolek.domain.entity.ExaminationEntity;
import com.projectbolek.domain.entity.ServiceEntity;
import com.projectbolek.domain.entity.VisitEntity;
import com.projectbolek.domain.model.dictionary.Service;
import com.projectbolek.domain.repository.ChargeRepository;
import com.projectbolek.domain.repository.ExaminationRepository;
import com.projectbolek.domain.repository.ServiceRepository;
import com.projectbolek.domain.repository.VisitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by rogalsp1 on 05.06.16.
 */
@org.springframework.stereotype.Service
@Slf4j
public class VisitService extends BaseService<VisitEntity>{

    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ChargeRepository chargeRepository;
    @Autowired
    private ExaminationRepository examinationRepository;

    @Override
    public CrudRepository<VisitEntity, Long> getRepository() {
        return visitRepository;
    }

    public List<VisitEntity> findVisitsByDates(Timestamp beginDate, Timestamp endDate) {
        return visitRepository.findVisitBetweenDates(beginDate, endDate);
    }

    public List<VisitEntity> findVisitsByPatientId(Long patientId) {
        return visitRepository.findVisitsByPatientId(patientId);
    }

    public List<VisitEntity> findPatientVisitsByDates(Long patientId, Timestamp beginDate, Timestamp endDate) {
        return visitRepository.findPatientVisitsByDates(patientId, beginDate, endDate);
    }

    @Transactional
    public void addNewVisit(VisitEntity visitEntity) {
        ServiceEntity service = serviceRepository.findOne(Service.INITIAL_EXAMINATION);
        ExaminationEntity examination = new ExaminationEntity();
        examination.setService(service);
        examination.setVisit(visitEntity);
        examination.setServiceDate(visitEntity.getBeginDateTime());
        ChargeEntity charge = new ChargeEntity();
        charge.setPatient(visitEntity.getPatient());
        charge.setExamination(examination);
        charge.setToPay(service.getPrice());
        charge.setInvoiceDate(Timestamp.valueOf(LocalDateTime.now()));
        visitRepository.save(visitEntity);
        examinationRepository.save(examination);
        chargeRepository.save(charge);
    }
}
