package katapackage.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import java.util.List;

import katapackage.model.User;

@Repository
public class UserDaoImpl implements UserDao {


    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<User> getUserList() {
        return entityManager.createQuery("From User", User.class).getResultList();
    }

    public User show(int id) {
        return entityManager.createQuery("from User where id=:i", User.class)
                .setParameter("i", id).getSingleResult();
    }

    public void save(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
    }

    public void update(int id, User user) {
        entityManager.joinTransaction();
        User UpdUser = show(id);
        UpdUser.setName(user.getName());
        UpdUser.setLastname(user.getLastname());
        entityManager.merge(user);
    }

    public void delete(int id) {
        entityManager.joinTransaction();
        try {
            entityManager.remove(show(id));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
