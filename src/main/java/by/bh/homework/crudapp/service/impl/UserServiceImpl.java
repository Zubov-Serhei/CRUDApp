package by.bh.homework.crudapp.service.impl;

import by.bh.homework.crudapp.dao.UserDAO;
import by.bh.homework.crudapp.model.User;
import by.bh.homework.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> list() {
        return userDAO.list();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    @Override
    public List<User> checkUserMailExists(String mail) {
        return userDAO.checkUserMailExists(mail);
    }
}
