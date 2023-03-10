package org.sp.config.controllers;

import org.sp.dao.PersonDAO;

import org.sp.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/people")
public class SecondController {

    private final PersonDAO personDAO;

    public SecondController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/list-page";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show-page";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/creation-page";
    }


    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personDAO.addPerson(person);
        return "redirect:/people";
    }


    @GetMapping("edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit-page";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
