package com.projectbolek.service;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.projectbolek.domain.model.User;
import com.projectbolek.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Service
public class UserService extends BaseService<User>{

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CrudRepository<User, Long> getRepository() {
        return userRepository;
    }
}
