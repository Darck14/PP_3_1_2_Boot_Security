package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void add(User user, List<String> roleNames);
    List<User> listUsers();
    User findById(long id);
    void update(User user, List<String> roleNames);
    void deleteById(long id);
    User showAuthorizedUser();
}
