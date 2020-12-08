package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public HttpStatus checkLogin(String login, String password) {
        return this.userRepository.checkLogin(login, password);
    }

}
