package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.ExaminationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rogalsp1 on 04.06.16.
 */
@Repository
public interface ExaminationRepository extends CrudRepository<ExaminationEntity, Long>{

    @Query("select ex from ExaminationEntity ex join  ex.visit v join v.patient p  where p.id = ?1")
    public List<ExaminationEntity> findExaminationsByPatient(Long patientId);

    @Query("select ex from ExaminationEntity ex join ex.visit v where v.id = ?1")
    public List<ExaminationEntity> findExaminationsByVisit(Long patientId);
}
