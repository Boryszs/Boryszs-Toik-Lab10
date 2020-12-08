package com.example.demo.service;

import com.example.demo.repository.UserRepository;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public Boolean checkLogin(String login, String password) {
        return this.userRepository.checkLogin(login, password);
    }

}
