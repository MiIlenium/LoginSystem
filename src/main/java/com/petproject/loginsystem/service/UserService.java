package com.petproject.loginsystem.service;

import com.petproject.loginsystem.controller.dto.UserDto;
import com.petproject.loginsystem.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
