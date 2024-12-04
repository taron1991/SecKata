package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {


     @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> userList() {
        return entityManager.createQuery("from User").getResultList();
    }

    public User addUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public void delById(long usserId) {
        entityManager.createQuery("delete from User where id=:id").setParameter("id",usserId).executeUpdate();
    }

    public User findById(long userId){
        return entityManager.find(User.class,userId);
    }

    @Override
    public User findByName(String name) {
        return  (User) entityManager.createQuery("from User where name =:name").setParameter("name",name).getSingleResult();
    }

    @Override
    public User findByEmail(String email) {
        return (User) entityManager.createQuery("from User where email =:email").setParameter("email",email).getSingleResult();

    }

    @Override
    public void delete(User item) {
        User deletedUser = entityManager.find(User.class, item.getId());
        entityManager.remove(deletedUser);
    }

    @Override
    public void update(User item, long id) {
        User updatedUser = findById(id);
        updatedUser.setName(item.getName());
        updatedUser.setEmail(item.getEmail());
        entityManager.merge(updatedUser);
    }
}
