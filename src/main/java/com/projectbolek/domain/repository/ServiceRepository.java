package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rogalsp1 on 06.06.16.
 */
@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {

}
