package ru.kata.spring.boot_security.demo.service;



import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> userList();

    User addUser(User user);

    void delById(long usserId);

    User findById(long userId);
    User findByEmail(String email);
    public void update(User item, long id);
    public void delete(User item);
}
