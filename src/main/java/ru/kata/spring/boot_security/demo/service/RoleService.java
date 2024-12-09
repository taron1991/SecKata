package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }
    public List<Role> getRolesList() {
        return roleDao.getRolesList();
    }
}
