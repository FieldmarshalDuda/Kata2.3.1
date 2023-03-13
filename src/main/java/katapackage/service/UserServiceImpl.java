package katapackage.service;

import katapackage.dao.UserDao;
import katapackage.dao.UserDaoImpl;
import katapackage.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Service
@Transactional
public class UserServiceImpl {
    private UserDao dao;
    public List<User> getUsers(){
        return dao.getUsers();
    }
    public User show(int id){
       return dao.show(id);
    }
    public void save(User user){ dao.save(user);}
    public void update(int id,User user){dao.update(id,user);}
    public void delete(int id){dao.delete(id);}
}
