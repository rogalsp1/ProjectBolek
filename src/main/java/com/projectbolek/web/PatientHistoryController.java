package com.projectbolek.web;

import com.projectbolek.domain.entity.PatientHistoryEntity;
import com.projectbolek.domain.model.dto.PatientHistoryDTO;
import com.projectbolek.service.PatientHistoryService;
import com.projectbolek.service.converter.PatientHistoryConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@RestController
@RequestMapping("/patienthistory")
@Slf4j

public class PatientHistoryController implements Serializable {

    private static final long serialVersionUID = 5760646545317636645L;
    private PatientHistoryService patientHistoryService;
    private PatientHistoryConverter converter;

    @Autowired
    public PatientHistoryController(PatientHistoryService patientHistoryService, PatientHistoryConverter converter) {
        this.patientHistoryService = patientHistoryService;
        this.converter = converter;
    }

    @RequestMapping(path = "/{patientId}", method = RequestMethod.GET)
    public List<PatientHistoryDTO> getPatientHistory(@PathVariable Long patientId) {
        List<PatientHistoryEntity> patientHistoryList = patientHistoryService.findByPatientId(patientId);
        return converter.fromEntity(patientHistoryList);
    }

    @RequestMapping(path = "/{patientId}", method = RequestMethod.POST)
    public ResponseEntity<?> savePatientHistory(@RequestBody PatientHistoryEntity patientHistoryEntity, @PathVariable Long patientId) {
        patientHistoryService.savePatientHistory(patientHistoryEntity, patientId);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
}
