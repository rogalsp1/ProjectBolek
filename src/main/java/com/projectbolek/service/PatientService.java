package com.projectbolek.service;

import com.projectbolek.domain.entity.ContactDetailsEntity;
import com.projectbolek.domain.entity.PatientEntity;
import com.projectbolek.domain.model.dto.NewPatientDTO;
import com.projectbolek.domain.model.enums.SexEnum;
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
    public void addNewPatient(NewPatientDTO patient) throws ApplicationException {
        if(isPeselUnique(patient.getPesel())){
            PatientEntity patientEntity = createNewPatientFromDTO(patient);
            ContactDetailsEntity contactDetails = createContactDetails(patient);
            patientEntity.setContactDetailsEntity(contactDetails);
            contactDetails.setPatient(patientEntity);
            patientRepository.save(patientEntity);
            contactDetailsRepository.save(contactDetails);
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

    private PatientEntity createNewPatientFromDTO(NewPatientDTO patientDTO) {
        PatientEntity patient = new PatientEntity();
        patient.setActive(true);
        patient.setRegistrationDate(Timestamp.valueOf(LocalDateTime.now()));
        patient.setBirthdate(patientDTO.getBirthdate());
        patient.setPesel(patientDTO.getPesel());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setSex(SexEnum.valueOf(patientDTO.getSex()));
        return patient;
    }

    private ContactDetailsEntity createContactDetails(NewPatientDTO patientDTO) {
        ContactDetailsEntity contactDetails = new ContactDetailsEntity();
        contactDetails.setCity(patientDTO.getCity());
        contactDetails.setCountry(patientDTO.getCountry());
        contactDetails.setPhoneNumber(patientDTO.getPhoneNumber());
        contactDetails.setProvince(patientDTO.getProvince());
        contactDetails.setStreet(patientDTO.getCity());
        return contactDetails;
    }
}
