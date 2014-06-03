package org.nerv.boilingriver.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by mark.lacdao on 30/05/2014.
 */
public class BaseDAO<T, ID extends Serializable> extends GenericDAOImpl<T, ID> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    @Override
    protected Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = sessionFactory.getCurrentSession();
        setSessionFactory(sessionFactory);
    }

}
