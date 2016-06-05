package com.projectbolek.web;

import com.projectbolek.domain.entity.ContactDetailsEntity;
import com.projectbolek.domain.entity.PatientEntity;
import com.projectbolek.domain.entity.VisitEntity;
import com.projectbolek.domain.model.dto.PatientDTO;
import com.projectbolek.domain.model.dto.VisitDTO;
import com.projectbolek.domain.model.exception.ApplicationException;
import com.projectbolek.service.PatientService;
import com.projectbolek.service.VisitService;
import com.projectbolek.service.converter.PatientConverter;
import com.projectbolek.service.converter.VisitConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by rogalsp1 on 30.05.16.
 */
@RestController
@RequestMapping("/patients")
@Slf4j
public class PatientController implements Serializable {

    private static final long serialVersionUID = -3606314241856173634L;

    private PatientService patientService;
    private PatientConverter patientConverter;
    private VisitService visitService;
    private VisitConverter visitConverter;

    @Autowired
    public PatientController(PatientService patientService, PatientConverter patientConverter, VisitService visitService) {
        this.patientService = patientService;
        this.patientConverter = patientConverter;
        this.visitService = visitService;
    }

    @RequestMapping(path = "/active", method = RequestMethod.GET)
    public List<PatientDTO> getActivePatients() {
        List<PatientEntity> patientList = patientService.findActivePatients();
        return patientConverter.fromEntity(patientList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewPatient(@RequestBody PatientDTO patientDTO) {
        PatientEntity patient = patientConverter.fromDTO(patientDTO);
        try {
            patientService.addNewPatient(patient);
        } catch (ApplicationException e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO) {
        PatientEntity patient = patientConverter.fromDTO(patientDTO);
        patientService.save(patient);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
    @RequestMapping(path = "/{patientId}", method = RequestMethod.POST)
    public ResponseEntity<?> getPatient(@PathVariable Long patientId) {
        patientService.findOne(patientId);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @RequestMapping(path = "/{patientId}/deactivate", method = RequestMethod.POST)
    public ResponseEntity<?> deactivatePatient(@PathVariable Long patientId) {
        patientService.deactivatePatient(patientId);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @RequestMapping(path = "/{patientId}/contactdetails", method = RequestMethod.GET)
    public ContactDetailsEntity getContactDetails(@PathVariable Long patientId) {
        return patientService.findContactDetailsByPatientId(patientId);
    }

    @RequestMapping(path = "/{patientId}/contactdetails", method = RequestMethod.POST)
    public ResponseEntity<?> saveContactDetails(@RequestBody ContactDetailsEntity contactDetailsEntity, @PathVariable Long patientId) {
        patientService.saveContactDetails(contactDetailsEntity, patientId);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @RequestMapping(path = "/{patientId}/visit", method = RequestMethod.GET)
    public List<VisitDTO> findVisitsByPatientId(@PathVariable Long patientId) {
        List<VisitEntity> visitList = visitService.findVisitsByPatientId(patientId);
        return visitConverter.fromEntity(visitList);
    }

    @RequestMapping(path = "/{patientId}/visitByDates", method = RequestMethod.GET)
    public List<VisitDTO> findVisitsByPatientIdAndDates(@PathVariable Long patientId, @RequestParam Long beginDate, @RequestParam Long endDate) {
        Timestamp begin = new Timestamp(beginDate);
        Timestamp end = new Timestamp(endDate);
        List<VisitEntity> visitList = visitService.findPatientVisitsByDates(patientId, begin, end);
        return visitConverter.fromEntity(visitList);
    }
}
