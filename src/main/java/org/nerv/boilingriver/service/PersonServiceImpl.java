package org.nerv.boilingriver.service;

import org.hibernate.SessionFactory;
import org.nerv.boilingriver.dao.PersonDao;
import org.nerv.boilingriver.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by mark.lacdao on 29/05/2014.
 */
@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    PersonDao personDao;

    @Override
    public Person createPerson(String name, Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }

    @Override
    @Transactional
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    @Transactional
    public void update(Person person) {
        personDao.update(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        personDao.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findById(Long id) {
        return personDao.find(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return personDao.findAll();
    }


}
