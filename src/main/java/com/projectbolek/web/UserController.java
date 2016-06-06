package com.projectbolek.web;

import com.projectbolek.domain.entity.UserEntity;
import com.projectbolek.domain.model.dto.PasswordDTO;
import com.projectbolek.domain.model.dto.SignInDTO;
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
import java.sql.Timestamp;
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

    @RequestMapping(path = "/availableDoctors", method = RequestMethod.GET)
    public List<UserDTO> getAvailableDoctors(@RequestParam Long beginDateTime, @RequestParam Long endDateTime) {
        Timestamp begin = new Timestamp(beginDateTime);
        Timestamp end = new Timestamp(endDateTime);
        List<UserEntity> userList = userService.findAvailableDoctors(begin, end);
        return converter.fromEntity(userList);
    }

    @RequestMapping(path = "/signin", method = RequestMethod.POST)
    public UserDTO signIn(@RequestBody SignInDTO signInDTO) throws LoginException {
        UserEntity user = userService.signIn(signInDTO.getUsername(), signInDTO.getPassword());
        return converter.fromEntity(user);
    }

    @RequestMapping(path = "/{userId}/changePassword", method = RequestMethod.PUT)
    public ResponseEntity<?> changePassword(@RequestBody PasswordDTO passwordDTO, @PathVariable Long userId) {
        userService.changePassword(passwordDTO.getPassword(), userId);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }
}
