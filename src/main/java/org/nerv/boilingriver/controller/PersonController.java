package org.nerv.boilingriver.controller;

import org.nerv.boilingriver.domain.Person;
import org.nerv.boilingriver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mark.lacdao on 30/05/2014.
 */
@Controller
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String viewDetails(ModelMap model, @PathVariable Long id){
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return "person/details";
    }

    @RequestMapping(value="/add/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {
        Person person = personService.createPerson(name, Integer.valueOf(10));
        personService.save(person);
        return "person/add";

    }

}
