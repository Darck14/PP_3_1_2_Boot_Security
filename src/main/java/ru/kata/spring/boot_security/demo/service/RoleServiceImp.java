package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void update(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }
    @Transactional
    @Override
    public Set<Role> iterateRoles(List<String> roleNames) {
        Set<Role> roles = new HashSet<>();
        for (String roleName : roleNames) {
            Role role = roleRepository.findByName(roleName)
                    .orElseGet(() -> {Role newRole = new Role(roleName);
                    return roleRepository.save(newRole);});
            roles.add(role);
        }
        return roles;
    }
}
