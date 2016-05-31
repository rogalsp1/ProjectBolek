package com.projectbolek.domain.repository;

import com.projectbolek.domain.model.Visit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by rogalsp1 on 30.05.16.
 */
@Repository
public interface VisitRepository extends CrudRepository<Visit, Long>{

}
