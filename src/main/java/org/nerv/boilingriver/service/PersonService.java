package org.nerv.boilingriver.service;

import org.nerv.boilingriver.domain.Person;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mark.lacdao on 29/05/2014.
 */
public interface PersonService {

    Person createPerson(String name, Integer age);

    void save(Person person);
    void update(Person person);
    void delete(Person person);
    Person findById(Long id);
    List<Person> findAll();

}
