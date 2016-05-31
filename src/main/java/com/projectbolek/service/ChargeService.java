package com.projectbolek.service;

import com.google.common.collect.Lists;
import com.projectbolek.domain.model.Charge;
import com.projectbolek.domain.repository.ChargeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rogalsp1 on 26.05.16.
 */
@Service
@Slf4j
public class ChargeService extends BaseService<Charge> implements Serializable{

    private static final long serialVersionUID = -3912845706287604053L;

    private ChargeRepository chargeRepository;

    @Autowired
    public ChargeService(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }

    @Override
    public CrudRepository<Charge, Long> getRepository() {
        return chargeRepository;
    }

    public List<Charge> findAll(){
        return Lists.newArrayList(chargeRepository.findAll());
    }
}
