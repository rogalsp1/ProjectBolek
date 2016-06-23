package com.projectbolek.web;

import com.projectbolek.domain.entity.ExaminationEntity;
import com.projectbolek.domain.model.dto.ExaminationDTO;
import com.projectbolek.service.ExaminationService;
import com.projectbolek.service.converter.ExaminationConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rogalsp1 on 23.06.16.
 */
@RestController
@Slf4j
@RequestMapping("/examinations")
public class ExaminationController implements Serializable {

    private static final long serialVersionUID = 1894311676334772145L;
    @Autowired
    private ExaminationService service;
    @Autowired
    private ExaminationConverter converter;

    @RequestMapping(value = "/byVisit", method = RequestMethod.GET)
    public List<ExaminationDTO> getVisitExaminations(@RequestParam Long visitId) {
        List<ExaminationEntity> examinationList = service.findExaminationsByVisit(visitId);
        return converter.fromEntity(examinationList);
    }
    @RequestMapping(value = "/byPatient", method = RequestMethod.GET)
    public List<ExaminationDTO> getPatientExaminations(@RequestParam Long patientId) {
        List<ExaminationEntity> examinationList = service.findExaminationsByPatient(patientId);
        return converter.fromEntity(examinationList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addNewExamination(@RequestBody ExaminationDTO examinationDTO) {
        ExaminationEntity examinationEntity = converter.fromDTO(examinationDTO);
        service.save(examinationEntity);
        return new ResponseEntity(null, HttpStatus.OK);
    }




}
