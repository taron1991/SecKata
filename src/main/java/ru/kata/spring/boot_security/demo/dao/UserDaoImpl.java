package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


     @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveUser(User user) {

        entityManager.merge(user);
    }

    @Override
    public void updateUser(User user) {

        entityManager.merge(user);
    }

    @Override
    public User findUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findUserByName(String name) {

        Query query = entityManager.createQuery("FROM User u where u.name = :name");
        query.setParameter("name", name);
        return (User) query.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {

        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.id = :userId")
                .setParameter("userId", id).executeUpdate();;
    }
}
