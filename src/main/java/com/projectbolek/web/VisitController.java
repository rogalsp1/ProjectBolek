package com.projectbolek.web;

import com.projectbolek.domain.entity.VisitEntity;
import com.projectbolek.domain.model.dto.VisitDTO;
import com.projectbolek.service.VisitService;
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
 * Created by rogalsp1 on 05.06.16.
 */
@RestController
@RequestMapping("/visits")
@Slf4j
public class VisitController implements Serializable {

    private static final long serialVersionUID = -3930382200451192262L;

    @Autowired
    private VisitService visitService;
    @Autowired
    private VisitConverter converter;

    @RequestMapping(method = RequestMethod.GET)
    public List<VisitDTO> getVisits() {
        List<VisitEntity> visitList = visitService.findAll();
        return converter.fromEntity(visitList);
    }

    @RequestMapping(path = "/byDate", method = RequestMethod.GET)
    public List<VisitDTO> getVisitsByDate(@RequestParam Long beginDateTime, @RequestParam Long endDateTime) {
        Timestamp begin = new Timestamp(beginDateTime);
        Timestamp end = new Timestamp(endDateTime);
        List<VisitEntity> visitList = visitService.findVisitsByDates(begin, end);
        return converter.fromEntity(visitList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveVisit(@RequestBody VisitDTO visitDTO) {
        VisitEntity visit = converter.fromDTO(visitDTO);
        visitService.addNewVisit(visit);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateVisit(@RequestBody VisitDTO visitDTO) {
        VisitEntity visit = converter.fromDTO(visitDTO);
        visitService.save(visit);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(path = "/{visitId}", method = RequestMethod.GET)
    public VisitDTO getVisit(@PathVariable Long visitId) {
        VisitEntity visitEntity = visitService.findOne(visitId);
        return converter.fromEntity(visitEntity);
    }

    @RequestMapping(path = "/{visitId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVisit(@PathVariable Long visitId) {
        visitService.delete(visitId);
        return new ResponseEntity<Object>(null,HttpStatus.OK);
    }

}