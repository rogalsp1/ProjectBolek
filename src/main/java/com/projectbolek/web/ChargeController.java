package com.projectbolek.web;

import com.projectbolek.domain.entity.ChargeEntity;
import com.projectbolek.domain.model.dto.ChargeDTO;
import com.projectbolek.service.ChargeService;
import com.projectbolek.service.converter.ChargeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rogalsp1 on 20.06.16.
 */
@RestController
@Slf4j
public class ChargeController implements Serializable{
    private static final long serialVersionUID = 3987443645012182847L;

    @Autowired
    private ChargeService chargeService;

    @Autowired
    private ChargeConverter chargeConverter;

    @RequestMapping(value = "patients/{id}/charges", method = RequestMethod.GET)
    public List<ChargeDTO> getPatientCharges(@PathVariable Long id) {
        List<ChargeEntity> chargeList = chargeService.getPatientCharges(id);
        return chargeConverter.fromEntity(chargeList);
    }

    @RequestMapping(value = "patients/{id}/paidCharges", method = RequestMethod.GET)
    public List<ChargeDTO> getPaidCharges(@PathVariable Long id) {
        boolean paid = true;
        List<ChargeEntity> chargeList = chargeService.getPatientCharges(id, paid);
        return chargeConverter.fromEntity(chargeList);
    }

    @RequestMapping(value = "patients/{id}/notPaidCharges", method = RequestMethod.GET)
    public List<ChargeDTO> getNotPaidCharges(@PathVariable Long id) {
        boolean paid = false;
        List<ChargeEntity> chargeList = chargeService.getPatientCharges(id, paid);
        return chargeConverter.fromEntity(chargeList);
    }
    @RequestMapping(value = "patients/{id}/charges", method = RequestMethod.PUT)
    public ResponseEntity<?> setChargePaid(@RequestParam Long chargeId) {
        chargeService.setChargePaid(chargeId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
