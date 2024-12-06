package ru.kata.spring.boot_security.demo.service;



import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void saveUser(User user);
    User findUser(Long id);
    List<User> listUsers();
    User findUserByName(String name);
    Set<Role> getSetOfRoles(List<String> id);
    void deleteUser(Long id);
    void updateUser(User user);
}
