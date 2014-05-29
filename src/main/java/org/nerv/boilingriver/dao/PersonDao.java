package org.nerv.boilingriver.dao;

import org.nerv.boilingriver.domain.Person;

/**
 * Created by mark.lacdao on 29/05/2014.
 */
public interface PersonDao {

    void save(Person person);
    void update(Person person);
    void delete(Person person);
    Person findById(Integer id);

}
