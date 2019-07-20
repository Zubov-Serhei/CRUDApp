package by.bh.homework.crudapp.dao.impl;

import by.bh.homework.crudapp.dao.UserDAO;
import by.bh.homework.crudapp.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class UserDAOImp implements UserDAO {

    private static Logger log = Logger.getLogger(UserDAOImp.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> list() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public User getUserById(Long id) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        Query<User> query = sessionFactory.getCurrentSession().createQuery(cq.select(root).where(cb.equal(root.get("id"),id)));
        List<User> results = query.getResultList();
        return results.get(0);
    }

    @Override
    public void deleteUser(Long id) {
        User user = sessionFactory.getCurrentSession().load(User.class,id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public List<User> checkUserMailExists(String mail) {
        return sessionFactory.getCurrentSession().createQuery("from User where mail =:mail")
                .setParameter("mail",mail)
                .list();
    }
}