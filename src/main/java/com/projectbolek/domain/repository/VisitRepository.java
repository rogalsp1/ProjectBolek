package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.VisitEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by rogalsp1 on 30.05.16.
 */
@Repository
public interface VisitRepository extends CrudRepository<VisitEntity, Long>{

    @Query("select v from VisitEntity v where v.beginDateTime between ?1 and ?2")
    List<VisitEntity> findVisitBetweenDates(Timestamp beginDateTime, Timestamp endDateTime);

    @Query("select v from VisitEntity v join v.patient p where p.id = ?1")
    List<VisitEntity> findVisitsByPatientId(Long patientId);

    @Query("select v from VisitEntity v join v.patient p where p.id = ?1 and v.beginDateTime between ?2 and ?3")
    List<VisitEntity> findPatientVisitsByDates(Long patientId, Timestamp beginDate, Timestamp endDate);


}
