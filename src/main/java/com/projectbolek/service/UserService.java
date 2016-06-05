package com.projectbolek.service;

import com.projectbolek.domain.entity.UserEntity;
import com.projectbolek.domain.model.exception.LoginException;
import com.projectbolek.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

import static com.projectbolek.util.BolekUtils.hashPassword;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@Service
@Slf4j
public class UserService extends BaseService<UserEntity> implements Serializable{

    private static final long serialVersionUID = -7047655185530312827L;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CrudRepository<UserEntity, Long> getRepository() {
        return userRepository;
    }

    @Transactional
    public void createUser(UserEntity userEntity) {
        String hashedPassword = hashPassword(userEntity.getPassword());
        userEntity.setPassword(hashedPassword);
        userRepository.save(userEntity);
        log.info("User created [" + userEntity.getFirstName() + " "
                + userEntity.getLastName()+"]");
    }

    @Transactional
    public void changePassword(String password, Long userId) {
        String hashedPassword = hashPassword(password);
        UserEntity user = userRepository.findOne(userId);
        user.setPassword(hashedPassword);
        userRepository.save(user);
        log.info("Password for user[" + userId + "] changed.");
    }

    public UserEntity signIn(String username, String password) throws LoginException {
        UserEntity user = userRepository.findUserEntityByUsername(username);
        if(user != null){
            String hashedPassword = hashPassword(password);
            hashedPassword.equals(user.getPassword());
            return user;
        } else {
            log.error("Username or password incorrect.");
            throw new LoginException("Username or password incorrect.");
        }
    }


}
