package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.ContactDetailsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rogalsp1 on 01.06.16.
 */
public interface ContactDetailsRepository extends CrudRepository<ContactDetailsEntity, Long>{

    @Query("select c from ContactDetailsEntity c join c.patient p where p.id = ?1")
    ContactDetailsEntity findContacDetailsEntityByPatientId(Long id);

}
