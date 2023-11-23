package com.petproject.loginsystem.service.impl;

import com.petproject.loginsystem.controller.dto.UserDto;
import com.petproject.loginsystem.entity.User;
import com.petproject.loginsystem.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Test
    void saveUser() {
        // setup
        UserDto userDto = new UserDto()
                .setFirstName("Andrew")
                .setLastName("Kekovich")
                .setEmail("kek@mail.com")
                .setLastName("Kekovich")
                .setPassword("1231231");

        // test
        userService.saveUser(userDto);

        // assert
        User user = userRepository.findByEmail("kek@mail.com");
        assertThat(user.getId(), notNullValue());
        assertThat(user.getName(), is("Andrew Kekovich"));
        assertThat(user.getEmail(), is("kek@mail.com"));
    }
}