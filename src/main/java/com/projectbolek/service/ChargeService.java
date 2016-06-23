package com.projectbolek.service;

import com.projectbolek.domain.entity.ChargeEntity;
import com.projectbolek.domain.repository.ChargeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by rogalsp1 on 26.05.16.
 */
@Service
@Slf4j
public class ChargeService extends BaseService<ChargeEntity> implements Serializable{

    private static final long serialVersionUID = -3912845706287604053L;
    private ChargeRepository chargeRepository;

    @Autowired
    public ChargeService(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }

    @Override
    public CrudRepository<ChargeEntity, Long> getRepository() {
        return chargeRepository;
    }

    public List<ChargeEntity> getPatientCharges(Long patientId) {
        return chargeRepository.findChargesByPatientId(patientId);
    }

    public List<ChargeEntity> getPatientCharges(Long patientId, Boolean paid) {
        return paid ? chargeRepository.findPaidChargesByPatientId(patientId)
                : chargeRepository.findNotPaidChargesByPatientId(patientId);
    }

    @Transactional
    public void setChargePaid(Long chargeId) {
        ChargeEntity charge = chargeRepository.findOne(chargeId);
        charge.setPaymentDate(Timestamp.valueOf(LocalDateTime.now()));
        chargeRepository.save(charge);
    }
}
