package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.VisitEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rogalsp1 on 30.05.16.
 */
@Repository
public interface VisitRepository extends CrudRepository<VisitEntity, Long>{

}
