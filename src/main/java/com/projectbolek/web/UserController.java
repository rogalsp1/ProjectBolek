package com.projectbolek.web;

import com.projectbolek.domain.entity.UserEntity;
import com.projectbolek.domain.model.dto.UserDTO;
import com.projectbolek.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rogalsp1 on 29.05.16.
 */
@RestController
@RequestMapping(path = "/users/")
@Slf4j
public class UserController implements Serializable{

    private static final long serialVersionUID = -7468108365944513924L;

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public List<UserEntity> getAllUsers(){
        return userService.findAll();
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> addNewUser(@RequestBody UserDTO user) {
/*        userService.save(input);
        log.info("New user created["+ input.getFirstName()+" "+input.getLastName()+"]");
        HttpHeaders httpHeaders = new HttpHeaders();
      */  return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
