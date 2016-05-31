package com.projectbolek.web;

import com.projectbolek.domain.model.ContactDetails;
import com.projectbolek.domain.model.Patient;
import com.projectbolek.domain.model.User;
import com.projectbolek.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
        //TODO
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @RequestMapping(path = "/deativate", method = RequestMethod.POST)
    public ResponseEntity<?> deactivatePatient(@RequestParam("id") Long patientId){
        //TODO
        return new ResponseEntity<Object>(null,HttpStatus.OK);
    }

    @RequestMapping(path = "/contactdetails", method = RequestMethod.GET)
    public ContactDetails getContactDetails(@RequestParam("id") Long patientId){
        //TODO
        return null;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient){
        //TODO
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
}