package com.projectbolek.domain.repository;

import com.projectbolek.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
