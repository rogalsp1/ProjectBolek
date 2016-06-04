package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.PatientEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by rogalsp1 on 30.05.16.
 */
@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, Long>{

    @Query(value = "select p from PatientEntity p where p.active = true ")
    List<PatientEntity> findActivePatients();

    @Modifying
    @Query(value = "update PatientEntity p set p.active = false where p.id = ?1")
    void deactivatePatient(Long id);

    Optional<PatientEntity> findPatientByPesel(String pesel);
}
