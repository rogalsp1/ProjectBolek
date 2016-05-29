package com.projectbolek.domain.repository;

import com.projectbolek.domain.model.Charge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rogalsp1 on 26.05.16.
 */
@Repository
public interface ChargeRepository extends CrudRepository<Charge, Long> {

}
