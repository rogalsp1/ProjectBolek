package com.projectbolek.service;

import com.projectbolek.domain.entity.ContactDetailsEntity;
import com.projectbolek.domain.entity.PatientEntity;
import com.projectbolek.domain.model.exception.ApplicationException;
import com.projectbolek.domain.repository.ContactDetailsRepository;
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

/**
 * Created by rogalsp1 on 30.05.16.
 */
@Service
@Slf4j
public class PatientService extends BaseService<PatientEntity> implements Serializable{

    private static final long serialVersionUID = -9032789337174910969L;

    private PatientRepository patientRepository;
    private ContactDetailsRepository contactDetailsRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, ContactDetailsRepository contactDetailsRepository) {
        this.patientRepository = patientRepository;
        this.contactDetailsRepository = contactDetailsRepository;
    }

    @Override
    public CrudRepository<PatientEntity, Long> getRepository() {
        return patientRepository;
    }

    public List<PatientEntity> findActivePatients(){
        return patientRepository.findActivePatients();
    }

    @Transactional
    public void deactivatePatient(Long id){
        patientRepository.deactivatePatient(id);
        log.info("deactivating patient ["+id+"]");
    }

    public ContactDetailsEntity findContactDetailsByPatientId(Long id){
        return contactDetailsRepository.findContacDetailsEntityByPatientId(id);
    }

    @Transactional
    public void addNewPatient(PatientEntity patient) throws ApplicationException {
        if(isPeselUnique(patient.getPesel())){
            patient.setRegistrationDate(Timestamp.valueOf(LocalDateTime.now()));
            patient.setActive(true);
            patientRepository.save(patient);
            log.info("new patient["+patient.getFirstName()+" "+patient.getLastName() +"] created");
        }
        else {
            log.debug("there is already patient with the same PESEL["+patient.getPesel()+"]");
            throw new ApplicationException("there is already patient with the same PESEL["+patient.getPesel()+"]");
        }
    }

    @Transactional
    public void saveContactDetails(ContactDetailsEntity contactDetailsEntity, Long patientId){
        PatientEntity patient = patientRepository.findOne(patientId);
        contactDetailsEntity.setPatient(patient);
        contactDetailsRepository.save(contactDetailsEntity);
    }
    private boolean isPeselUnique(String pesel){
        return !patientRepository.findPatientByPesel(pesel).isPresent();
    }
}
