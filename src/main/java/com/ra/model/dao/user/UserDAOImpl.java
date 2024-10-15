package com.ra.model.dao.user;

import com.ra.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean create(User user) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception exception){
            session.getTransaction().rollback();
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public User findUserByEmail(String email) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "from User as u where u.email =:_email";
            return session.createQuery(hql,User.class).
                    setParameter("_email",email).getSingleResult();
        } catch (Exception exception){
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
