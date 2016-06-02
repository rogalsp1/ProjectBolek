package com.projectbolek.service;

import com.projectbolek.domain.model.ContactDetails;
import com.projectbolek.domain.model.Patient;
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
public class PatientService extends BaseService<Patient> implements Serializable{

    private static final long serialVersionUID = -9032789337174910969L;

    private PatientRepository patientRepository;
    private ContactDetailsRepository contactDetailsRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, ContactDetailsRepository contactDetailsRepository) {
        this.patientRepository = patientRepository;
        this.contactDetailsRepository = contactDetailsRepository;
    }

    @Override
    public CrudRepository<Patient, Long> getRepository() {
        return patientRepository;
    }

    public List<Patient> findActivePatients(){
        return patientRepository.findActivePatients();
    }

    @Transactional
    public void deactivatePatient(Long id){
        patientRepository.deactivatePatient(id);
        log.info("deactivating patient ["+id+"]");
    }

    public ContactDetails findContactDetailsByPatientId(Long id){
        return contactDetailsRepository.findContacDetailstByPatientId(id);
    }

    @Transactional
    public void addNewPatient(Patient patient) throws ApplicationException {
        if(isPeselUnique(patient.getPesel())){
            patient.setRegistrationDate(Timestamp.valueOf(LocalDateTime.now()));
            patient.setActive(true);
            patientRepository.save(patient);
            log.info("new patient created");
        }
        else {
            log.debug("there is already patient with the same PESEL["+patient.getPesel()+"]");
            throw new ApplicationException("there is already patient with the same PESEL["+patient.getPesel()+"]");
        }
    }

    @Transactional
    public void saveContactDetails(ContactDetails contactDetails, Long patientId){
        Patient patient = patientRepository.findOne(patientId);
        contactDetails.setPatient(patient);
        contactDetailsRepository.save(contactDetails);
    }
    private boolean isPeselUnique(String pesel){
        return !patientRepository.findPatientByPesel(pesel).isPresent();
    }

}
