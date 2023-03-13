package katapackage.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import katapackage.model.User;
import katapackage.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao{
    public UserDaoImpl(EntityManager em){
    }

    private static int USER_COUNT;
    private List<User> users;
    {
        users=new ArrayList<>();
        users.add(new User(++USER_COUNT,"Ruby","Jefferson"));
        users.add(new User(++USER_COUNT,"Abraham","Peepoo"));
        users.add(new User(++USER_COUNT,"Ogre","Magi","missisluck@dumbo.com"));
    }
    public List<User> getUsers(){
        return users;
    }
    public User show(int id){
        return users.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }
    public void update(int id,User user){
        User UpdUser = show(id);
        UpdUser.setName(user.getName());
        UpdUser.setLastname(user.getLastname());
    }
    public void delete(int id){
        users.removeIf(u->u.getId()==id);
    }
}
