package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> userList() {
        return userDao.userList();
    }

    @Transactional
    public User addUser(User user){
        return userDao.addUser(user);
    }

    @Transactional
    public void delById(long usserId){
        userDao.delById(usserId);
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
    public void update(User item, long id) {
        userDao.update(item, id);
    }

    @Transactional
    @Override
    public void delete(User item) {
        userDao.delete(item);
    }

    @Transactional
    public void deleteItem(User item) {
        userDao.delete(item);
    }
}
