package com.projectbolek.service;

import com.projectbolek.domain.entity.VisitEntity;
import com.projectbolek.domain.repository.VisitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by rogalsp1 on 05.06.16.
 */
@Service
@Slf4j
public class VisitService extends BaseService<VisitEntity>{

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public CrudRepository<VisitEntity, Long> getRepository() {
        return visitRepository;
    }

    public List<VisitEntity> findVisitsByDates(Timestamp beginDate, Timestamp endDate) {
        return visitRepository.findVisitBetweenDates(beginDate, endDate);
    }

    public List<VisitEntity> findVisitsByPatientId(Long patientId) {
        return visitRepository.findVisitsByPatientId(patientId);
    }

    public List<VisitEntity> findPatientVisitsByDates(Long patientId, Timestamp beginDate, Timestamp endDate) {
        return visitRepository.findPatientVisitsByDates(patientId, beginDate, endDate);
    }
}
