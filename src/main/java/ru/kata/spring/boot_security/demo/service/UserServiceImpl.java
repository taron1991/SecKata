package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.entity.User;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {


    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> userList() {
        return userDao.userList();
    }

    @Transactional
    public User addUser(User user){
        User userToSave = new User();
        userToSave.setName(user.getName());
        userToSave.setEmail(user.getEmail());
        userToSave.setPassword(passwordEncoder.encode(user.getPassword()));
        userToSave.setRoles(user.getRoles());

        return userDao.addUser(userToSave);
    }

    @Transactional
    public void delById(long userId){
        userDao.delById(userId);
    }

    public User findById(long userId){
        return userDao.findById(userId);
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Transactional
    @Override
    public void update(User user, long id) {
        userDao.update(user, id);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    public void deleteItem(User user) {
        userDao.delete(user);
    }
}
