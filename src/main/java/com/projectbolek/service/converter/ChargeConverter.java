package com.projectbolek.service.converter;

import com.projectbolek.domain.entity.ChargeEntity;
import com.projectbolek.domain.model.dto.ChargeDTO;
import org.springframework.stereotype.Component;

/**
 * Created by rogalsp1 on 03.06.16.
 */
@Component
public class ChargeConverter implements EntityDTOConverter<ChargeEntity,ChargeDTO> {

    @Override
    public ChargeEntity fromDTO(ChargeDTO chargeDTO) {
        return null;
    }

    @Override
    public ChargeDTO fromEntity(ChargeEntity chargeEntity) {
        ChargeDTO chargeDTO = new ChargeDTO();
        chargeDTO.setId(chargeEntity.getId());
        chargeDTO.setToPay(chargeEntity.getToPay());
        chargeDTO.setInvoiceDate(chargeEntity.getInvoiceDate());
        chargeDTO.setPaymantDate(chargeEntity.getPaymentDate());
        chargeDTO.setPatient(chargeEntity.getPatient().getId());
        chargeDTO.setExamination(chargeEntity.getExamination().getId());
        return chargeDTO;
    }
}
