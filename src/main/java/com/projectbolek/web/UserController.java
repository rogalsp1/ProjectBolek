package com.projectbolek.web;

import com.projectbolek.domain.model.User;
import com.projectbolek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
public class UserController implements Serializable{

    private static final long serialVersionUID = -7468108365944513924L;

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(path = "/userlist",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @RequestMapping(path = "/newUser", method = RequestMethod.POST)
    ResponseEntity<?> addNewUser(@RequestBody User input) {
        userService.save(input);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null,httpHeaders, HttpStatus.CREATED);
    }
}
