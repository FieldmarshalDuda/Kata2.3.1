package katapackage.dao;

import katapackage.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    List<User> getUserList();
    User show(int id);
    void save(User user);
    void update(int id,User user);
    void delete(int id);
}
