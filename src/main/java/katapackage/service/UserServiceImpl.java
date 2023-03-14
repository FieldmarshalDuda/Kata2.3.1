package katapackage.service;

import katapackage.dao.UserDao;
import katapackage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class UserServiceImpl implements UserService{

    private final UserDao dao;
    @Autowired
    public UserServiceImpl(UserDao dao){
        this.dao=dao;
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers(){
        return dao.getUserList();
    }
    @Transactional(readOnly = true)
    @Override
    public User show(int id){
       return dao.show(id);
    }
    @Override
    public void save(User user){ dao.save(user);}
    @Override
    public void update(int id,User user){dao.update(id,user);}
    @Override
    public void delete(int id){dao.delete(id);}
}
