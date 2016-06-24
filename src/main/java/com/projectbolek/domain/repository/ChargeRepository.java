package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.ChargeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rogalsp1 on 26.05.16.
 */
@Repository
public interface ChargeRepository extends CrudRepository<ChargeEntity, Long> {

    @Query("select ch from ChargeEntity ch join ch.patient p where p.id = ?1")
    List<ChargeEntity> findChargesByPatientId(Long patientId);

    @Query("select ch from ChargeEntity ch join ch.patient p where p.id = ?1 and ch.paymentDate is null")
    List<ChargeEntity> findNotPaidChargesByPatientId(Long patientId);

    @Query("select ch from ChargeEntity ch join ch.patient p where p.id = ?1 and ch.paymentDate is not null")
    List<ChargeEntity> findPaidChargesByPatientId(Long patientId);

}
