package com.projectbolek.service;

import com.projectbolek.domain.model.User;
import com.projectbolek.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Service
@Slf4j
public class UserService extends BaseService<User> implements Serializable{

    private static final long serialVersionUID = -7047655185530312827L;
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
