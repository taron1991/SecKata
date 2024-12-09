package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.Role;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager factoryBean;

    public List<Role> getRolesList() {


        return factoryBean.createQuery("from Role").getResultList();
    }

    public Role getRoleById(Long id) {

        return factoryBean.find(Role.class, id);

    }
}