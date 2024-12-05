package ru.kata.spring.boot_security.demo.dao;



import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserDao {
     List<User> userList();
    User addUser(User user);

     void delById(long userId);

    User findById(long userId);

    User findByName(String name);
    User findByEmail(String email);
     void delete(User user) ;
     void update(User user, long id);
}
