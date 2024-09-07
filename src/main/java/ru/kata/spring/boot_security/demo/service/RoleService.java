package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    void add(Role role);
    List<Role> listRoles();
    Role findById(long id);
    void update(Role role);
    void deleteById(long id);
    Set<Role> iterateRoles(List<String> roleNames);
}
