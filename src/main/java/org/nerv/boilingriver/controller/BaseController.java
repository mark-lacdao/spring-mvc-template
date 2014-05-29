package org.nerv.boilingriver.controller;

import org.nerv.boilingriver.domain.Person;
import org.nerv.boilingriver.service.PersonService;
import org.nerv.boilingriver.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mark.lacdao on 21/05/2014.
 */
@Controller
public class BaseController {

    @Autowired
    private SampleService sampleService;

    @Autowired
    private PersonService personService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");

        //Spring uses InternalResourceViewResolver and return back index.jsp
        return "index";

    }

    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {

        model.addAttribute("message", "Maven Web Project + Spring 3 MVC - " + sampleService.reverse(name));
        Person person = personService.createPerson(name, Integer.valueOf(10));
        personService.save(person);
        return "index";

    }

}
