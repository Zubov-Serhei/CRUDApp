package by.bh.homework.crudapp.dao;

import by.bh.homework.crudapp.model.User;

import java.util.List;
public interface UserDAO {
    void save(User user);
    List<User> list();
    User getUserById(Long id);
    void deleteUser(Long id);
}
