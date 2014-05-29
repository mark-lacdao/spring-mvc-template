package org.nerv.boilingriver.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.nerv.boilingriver.domain.Person;
import org.nerv.boilingriver.hibernate.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mark.lacdao on 29/05/2014.
 */
@Repository
public class PersonDaoImpl extends CustomHibernateDaoSupport implements PersonDao {

    @Override
    public void save(Person person) {
        System.out.println("Saving person with name ".concat(person.getName()));
        getHibernateTemplate().save(person);
    }

    @Override
    public void update(Person person) {
        getHibernateTemplate().update(person);
    }

    @Override
    public void delete(Person person) {
        getHibernateTemplate().delete(person);
    }

    @Override
    public Person findById(Integer id) {
        DetachedCriteria detachedCriteria = getDetachedCriteria();
        detachedCriteria.add(Restrictions.eq("ID", id));
        List<Person> persons = getHibernateTemplate().findByCriteria(detachedCriteria);
        return persons.get(0);
    }

    private DetachedCriteria getDetachedCriteria(){
        return DetachedCriteria.forClass(Person.class);
    }

}
