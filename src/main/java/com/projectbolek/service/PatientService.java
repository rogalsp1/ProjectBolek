package com.projectbolek.service;

import com.projectbolek.domain.model.ContactDetails;
import com.projectbolek.domain.model.Patient;
import com.projectbolek.domain.repository.ContactDetailsRepository;
import com.projectbolek.domain.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rogalsp1 on 30.05.16.
 */
@Service
@Slf4j
public class PatientService implements Serializable{

    private static final long serialVersionUID = -9032789337174910969L;

    private PatientRepository patientRepository;
    private ContactDetailsRepository contactDetailsRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, ContactDetailsRepository contactDetailsRepository) {
        this.patientRepository = patientRepository;
        this.contactDetailsRepository = contactDetailsRepository;
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

}
