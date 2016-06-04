package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.ChargeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rogalsp1 on 26.05.16.
 */
@Repository
public interface ChargeRepository extends CrudRepository<ChargeEntity, Long> {

}
