package org.sp.config.controllers;

import org.sp.dao.PersonDAO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class SecondController {

    private final PersonDAO personDAO;

    public SecondController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping("/people")
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/people/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}
