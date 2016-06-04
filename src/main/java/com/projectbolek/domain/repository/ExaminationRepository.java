package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.ExaminationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rogalsp1 on 04.06.16.
 */
@Repository
public interface ExaminationRepository extends CrudRepository<ExaminationEntity, Long>{



}
