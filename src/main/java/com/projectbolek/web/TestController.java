package com.projectbolek.web;

import com.projectbolek.domain.model.Charge;
import com.projectbolek.service.ChargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rogalsp1 on 26.05.16.
 */
@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    private ChargeService chargeService;

    @Autowired
    public TestController(ChargeService chargeService){
        this.chargeService = chargeService;
    }

    @RequestMapping(path = "/")
    private List<Charge> Test(){
        logger.info("TEST");
        return chargeService.findAll();
    }
}
