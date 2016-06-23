package com.projectbolek.web;

import com.projectbolek.domain.entity.ServiceEntity;
import com.projectbolek.domain.model.dto.ServiceDTO;
import com.projectbolek.service.MedicalServiceService;
import com.projectbolek.service.converter.MedicalServiceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rogalsp1 on 21.06.16.
 */
@RestController
@RequestMapping("/services/")
public class ServiceController implements Serializable{

    private static final long serialVersionUID = -4491323339244890840L;

    @Autowired
    private MedicalServiceService service;
    @Autowired
    private MedicalServiceConverter converter;

    @RequestMapping(method = RequestMethod.GET)
    public List<ServiceDTO> getAllServices() {
        List<ServiceEntity> serviceList = service.findAll();
        return converter.fromEntity(serviceList);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteService(@RequestParam Long serviceId) {
        service.delete(serviceId);
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
