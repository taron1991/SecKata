package ru.kata.spring.boot_security.demo.dao;



import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    public List<User> userList();
    User addUser(User user);

    public void delById(long usserId);

    User findById(long userId);

    User findByName(String name);
    User findByEmail(String email);
    public void delete(User item) ;
    public void update(User item, long id);
}
