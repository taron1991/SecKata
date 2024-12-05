package ru.kata.spring.boot_security.demo.service;



import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> userList();

    User addUser(User user);

    void delById(long userId);

    User findById(long userId);
    User findByEmail(String email);
     void update(User user, long id);
     void delete(User user);
}
