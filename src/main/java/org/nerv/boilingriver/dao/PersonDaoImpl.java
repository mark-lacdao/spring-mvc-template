package org.nerv.boilingriver.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.nerv.boilingriver.domain.Person;
import org.nerv.boilingriver.hibernate.CustomHibernateDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mark.lacdao on 29/05/2014.
 */
@Repository
public class PersonDaoImpl extends CustomHibernateDaoSupport implements PersonDao {


    @Override
    public void save(Person person) {
        getHibernateTemplate().save(person);
    }

    @Override
    public void update(Person person) {
        getHibernateTemplate().saveOrUpdate(person);
    }

    @Override
    public void delete(Person person) {
        getHibernateTemplate().delete(person);
    }

    @Override
    public Person find(Long id) {
        DetachedCriteria detachedCriteria = getDetachedCriteria();
        detachedCriteria.add(Restrictions.eq("id", id));
        List<Person> persons = getHibernateTemplate().findByCriteria(detachedCriteria);
        return persons.get(0);
    }

    @Override
    public List<Person> findAll() {
        //TODO: Implement
        return null;
    }

    private DetachedCriteria getDetachedCriteria(){
        return DetachedCriteria.forClass(Person.class);
    }
}
