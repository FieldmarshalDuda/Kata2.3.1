package katapackage.dao;

import katapackage.model.User;

import java.util.List;
public interface UserDao {

    List<User> getUserList();
    User show(int id);
    void save(User user);
    void update(int id,User user);
    void delete(int id);
}
