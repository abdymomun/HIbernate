package peaksoft.dao;

import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    Session session = Util.getSession().openSession();


    @Override
    public void dropUsersTable() {
        try {
            session.beginTransaction();
            session.getTransaction();
            session.createNativeQuery("drop table users").executeUpdate();
        }catch (Exception e){
            if (session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
session.beginTransaction();
session.persist(user);
session.getTransaction().commit();
session.close();
    }

    @Override
    public void removeUserById(long id) {
session.beginTransaction();
User user = session.get(User.class,id);
session.remove(user);
session.update(user);
session.getTransaction().commit();
session.close();
    }

    @Override
    public List<User> getAllUsers() {
        session.beginTransaction();
        List<User>users =session.createQuery("select u from User u", User.class).getResultList();
session.getTransaction().commit();
session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
session.beginTransaction();
User user = session.createQuery("select u from User u", User.class).uniqueResult();
session.remove(user);
session.getTransaction().commit();
session.close();
    }
}
