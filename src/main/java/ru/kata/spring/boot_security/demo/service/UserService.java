package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    void add(User user, List<String> roleNames);
    List<User> listUsers();
    User findById(long id);
    void update(User user, List<String> roleNames);
    void deleteById(long id);
    User showAuthorizedUser();
}
