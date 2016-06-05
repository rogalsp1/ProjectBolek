package com.projectbolek.service;

import com.projectbolek.domain.entity.PatientEntity;
import com.projectbolek.domain.entity.PatientHistoryEntity;
import com.projectbolek.domain.repository.PatientHistoryRepository;
import com.projectbolek.domain.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class PatientHistoryService extends BaseService<PatientHistoryEntity> implements Serializable{

    private PatientRepository patientRepository;
    private PatientHistoryRepository patientHistoryRepository;


    @Autowired
    public PatientHistoryService(PatientRepository patientRepository, PatientHistoryRepository patientHistoryRepository) {
        this.patientRepository = patientRepository;
        this.patientHistoryRepository = patientHistoryRepository;
    }

    @Override
    public CrudRepository<PatientHistoryEntity, Long> getRepository() {
        return patientHistoryRepository;
    }

    public List<PatientHistoryEntity> findByPatientId(Long patentId) {
        return patientHistoryRepository.findByPatientId(patentId);
    }

    @Transactional
    public void savePatientHistory(PatientHistoryEntity patientHistoryEntity, Long patientId){
        PatientEntity patient = patientRepository.findOne(patientId);
        patientHistoryEntity.setPatient(patient);
        patientHistoryEntity.setDate(Timestamp.valueOf(LocalDateTime.now()));
        patientHistoryRepository.save(patientHistoryEntity);
    }

}
