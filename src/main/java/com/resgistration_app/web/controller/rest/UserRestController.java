package com.resgistration_app.web.controller.rest;

import com.resgistration_app.entity.User;
import com.resgistration_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all-users")
    public Iterable<User> findAllUsers() {
        return userService.getAllUsers();
    }

}
