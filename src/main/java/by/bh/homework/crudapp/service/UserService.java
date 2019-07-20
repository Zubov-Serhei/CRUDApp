package by.bh.homework.crudapp.service;

import by.bh.homework.crudapp.model.User;

import java.util.List;
public interface UserService {

    void save(User user);
    List<User> list();
    User getUserById(Long id);
    void deleteUser(Long id);
    List<User> checkUserMailExists(String mail);
}
