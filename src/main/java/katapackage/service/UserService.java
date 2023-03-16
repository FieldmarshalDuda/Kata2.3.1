package katapackage.service;
import katapackage.model.User;

import java.util.List;
public interface UserService {

    List<User> getUsers();
    User show(int id);
    void save(User user);
    void update(int id,User user);
    void delete(int id);
}
