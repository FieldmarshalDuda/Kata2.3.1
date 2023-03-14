package katapackage.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import katapackage.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class UserDaoImpl implements UserDao{

    private final EntityManager entityManager;
    public UserDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }



    public List<User> getUserList(){
        return entityManager.createQuery("FROM User",User.class).getResultList();
    }
    public User show(int id){return entityManager.createQuery("from User where id=:i",User.class).getSingleResult();}
    public void save(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
    }
    public void update(int id,User user){
        entityManager.joinTransaction();
        User UpdUser = show(id);
        UpdUser.setName(user.getName());
        UpdUser.setLastname(user.getLastname());
        entityManager.persist(user);
    }
    public void delete(int id){
        entityManager.joinTransaction();
        try{
            entityManager.remove(show(id));
        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
