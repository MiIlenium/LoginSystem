package com.petproject.loginsystem.service.impl;

import com.petproject.loginsystem.controller.dto.UserDto;
import com.petproject.loginsystem.entity.User;
import com.petproject.loginsystem.repository.UserRepository;
import com.petproject.loginsystem.service.UserService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import com.petproject.loginsystem.security.Encrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    //private PasswordEncoder passwordEncoder;
    private Encrypt passwordEncrypt;

    public UserServiceImpl(UserRepository userRepository,
                           Encrypt passwordEncrypt) {
        this.userRepository = userRepository;
        //his.passwordEncrypt = passwordEncrypt;
    }
    @Override
    public void saveUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        //String below can be replaced with the following:
        //user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPassword(passwordEncrypt.stringToEncrypt(userDto.getPassword()));

        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }
    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }
}
