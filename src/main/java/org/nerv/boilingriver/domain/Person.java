package org.nerv.boilingriver.domain;



import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by mark.lacdao on 29/05/2014.
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

    private Long id;
    private String name;
    private Integer age;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", unique = false, nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "AGE", unique = false, nullable = false, length = 10)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
