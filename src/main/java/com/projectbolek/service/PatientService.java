package com.projectbolek.service;

import com.projectbolek.domain.model.Patient;
import com.projectbolek.domain.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> findActivePatients(){
        return patientRepository.findActivePatients();
    }

    @Transactional
    public void deactivatePatient(Long id){
        patientRepository.deactivatePatient(id);
        log.info("deactivating patient ["+id+"]");
    }

}
