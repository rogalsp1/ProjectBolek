package com.projectbolek.domain.repository;

import com.projectbolek.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{

    UserEntity findUserEntityByUsername(String username);

    @Query("select u from VisitEntity v join v.user u where u.doctor = true and v.beginDateTime not between ?1 and ?2")
    List<UserEntity> findAvailableDoctors (Timestamp begin, Timestamp end);
}
