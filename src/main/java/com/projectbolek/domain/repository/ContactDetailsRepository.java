package com.projectbolek.domain.repository;

import com.projectbolek.domain.model.ContactDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rogalsp1 on 01.06.16.
 */
public interface ContactDetailsRepository extends CrudRepository<ContactDetails, Long>{

    @Query("select c from ContactDetails c join c.patient p where p.id = ?1")
    ContactDetails findContacDetailstByPatientId(Long id);

}
