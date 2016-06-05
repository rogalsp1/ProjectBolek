package com.projectbolek.web;

import com.projectbolek.domain.entity.UserEntity;
import com.projectbolek.domain.model.dto.UserDTO;
import com.projectbolek.domain.model.exception.LoginException;
import com.projectbolek.service.UserService;
import com.projectbolek.service.converter.UserConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@RestController
@RequestMapping(path = "/users")
@Slf4j
public class UserController implements Serializable{

    private static final long serialVersionUID = -7468108365944513924L;

    private UserService userService;
    private UserConverter converter;

    @Autowired
    public UserController(UserService userService, UserConverter converter){
        this.userService = userService;
        this.converter = converter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDTO> getAllUsers(){
        return converter.fromEntity(userService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = converter.fromDTO(userDTO);
        userService.createUser(userEntity);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = converter.fromDTO(userDTO);
        userService.save(userEntity);
        log.info("User updated [" + userEntity.getFirstName() + " "
                + userEntity.getLastName()+"]");
        return new ResponseEntity<Object>(null,HttpStatus.OK);
    }

    @RequestMapping(path = "/{user_id}/change_password", method = RequestMethod.PUT)
    public ResponseEntity<?> changePassword(@RequestParam("password") String password, @PathVariable("user_id") Long userId) {
        userService.changePassword(password, userId);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @RequestMapping(path = "/signin", method = RequestMethod.GET)
    public UserDTO signIn(@RequestParam("username") String username, @RequestParam("password") String password) throws LoginException {
        UserEntity user = userService.signIn(username, password);
        return converter.fromEntity(user);
    }

}
