package com.resgistration_app.service;

import com.resgistration_app.entity.User;
import com.resgistration_app.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    User save(UserRegistrationDto dto);
}
