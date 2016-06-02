package com.projectbolek.domain.repository;

import com.projectbolek.domain.model.Patient;
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
public interface PatientRepository extends CrudRepository<Patient, Long>{

    @Query(value = "select p from Patient p where p.active = true ")
    List<Patient> findActivePatients();

    @Modifying
    @Query(value = "update Patient p set p.active = false where p.id = ?1")
    void deactivatePatient(Long id);

    Optional<Patient> findPatientByPesel(String pesel);
}
