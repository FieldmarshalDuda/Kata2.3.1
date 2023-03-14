package katapackage.service;
import katapackage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    List<User> getUsers();
    User show(int id);
    void save(User user);
    void update(int id,User user);
    void delete(int id);
}
