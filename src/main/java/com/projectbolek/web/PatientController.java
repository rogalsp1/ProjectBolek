package com.projectbolek.web;

import com.projectbolek.domain.model.ContactDetails;
import com.projectbolek.domain.model.Patient;
import com.projectbolek.domain.model.exception.ApplicationException;
import com.projectbolek.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rogalsp1 on 30.05.16.
 */
@RestController
@RequestMapping(path = "/patients/")
@Slf4j
public class PatientController implements Serializable{

    private static final long serialVersionUID = -3606314241856173634L;

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(path = "/active", method = RequestMethod.GET)
    public List<Patient> getActivePatients(){
        return patientService.findActivePatients();
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> addNewPatient(@RequestBody Patient patient){
        try {
            patientService.addNewPatient(patient);
        } catch (ApplicationException e) {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @RequestMapping(path = "/deactivate", method = RequestMethod.POST)
    public ResponseEntity<?> deactivatePatient(@RequestParam("id") Long patientId){
        patientService.deactivatePatient(patientId);
        return new ResponseEntity<Object>(null,HttpStatus.OK);
    }

    @RequestMapping(path = "/contactdetails", method = RequestMethod.GET)
    public ContactDetails getContactDetails(@RequestParam("id") Long patientId){
        return patientService.findContactDetailsByPatientId(patientId);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient){
        patientService.save(patient);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @RequestMapping(path= "/saveContact", method = RequestMethod.POST)
    public ResponseEntity<?> saveContactDetails(@RequestBody ContactDetails contactDetails, @RequestParam("patient_id") Long id){
        patientService.saveContactDetails(contactDetails,id);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
}
