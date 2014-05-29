package org.nerv.boilingriver.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by mark.lacdao on 29/05/2014.
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

    @Autowired
    public void setupSessionFactory(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }

}
