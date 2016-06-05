package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.ChargeEntity;
import com.projectbolek.domain.entity.PatientHistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientHistoryRepository extends CrudRepository<PatientHistoryEntity, Long> {
    List<PatientHistoryEntity> findByPatientId(Long id);
}
