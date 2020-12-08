package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

public class UserRepository {

    private final int Size=3;
    private final Map<Integer, User> usersDatabase;

    public UserRepository() {
        usersDatabase = new HashMap<>();

        usersDatabase.put(1, new User("cracker", "cracker1234", true, 0));
        usersDatabase.put(2, new User("marry", "marietta!#09", true, 0));
        usersDatabase.put(3, new User("silver", "$silver$", true, 0));
    }

    public HttpStatus checkLogin(final String login, final String password) {

        for (Map.Entry<Integer, User> entry : usersDatabase.entrySet()) {
            if (entry.getValue().getLogin().equals(login) && !entry.getValue().getPassword().equals(password) && entry.getValue().isActive() == true) {
                if (entry.getValue().isActive() == true) {
                    entry.getValue().setIncorrectLoginCounter(entry.getValue().getIncorrectLoginCounter() + 1);
                }
                if (entry.getValue().isActive() == true && entry.getValue().getIncorrectLoginCounter() == Size) {
                    entry.getValue().setActive(false);
                }
                else{
                    return HttpStatus.UNAUTHORIZED;
                }
            } else if (entry.getValue().getLogin().equals(login) && entry.getValue().getPassword().equals(password) && entry.getValue().isActive() == true) {
                entry.getValue().setIncorrectLoginCounter(0);
                return HttpStatus.OK;
            }
        }
        return HttpStatus.FORBIDDEN;
    }

}
