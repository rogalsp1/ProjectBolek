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
public class ExaminationController implements Serializable {

    private static final long serialVersionUID = 1894311676334772145L;
    @Autowired
    private ExaminationService service;
    @Autowired
    private ExaminationConverter converter;

    @RequestMapping(value = "/visits/{id}/examinations", method = RequestMethod.GET)
    public List<ExaminationDTO> getExaminations(@PathVariable Long id) {
        List<ExaminationEntity> examinationList = service.findExaminationsByVisit(id);
        return converter.fromEntity(examinationList);
    }

    @RequestMapping(value = "/examinations", method = RequestMethod.POST)
    public ResponseEntity addNewExamination(@RequestBody ExaminationDTO examinationDTO) {
        ExaminationEntity examinationEntity = converter.fromDTO(examinationDTO);
        service.addNewExamination(examinationEntity);
        return new ResponseEntity(null, HttpStatus.OK);
    }




}
