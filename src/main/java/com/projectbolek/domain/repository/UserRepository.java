package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{

    UserEntity findUserEntityByUsername(String username);
}
