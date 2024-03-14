package com.example.lesson.controller;

import com.example.lesson.models.Person;
import com.example.lesson.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;


    @GetMapping("/user")
    public String listPerson(Model model){
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "person/person";
    }

    @GetMapping("/admin/add")
    public String addPersonForm(Model model){
        model.addAttribute("person", new Person());
        return "person/add-person";
    }

    @PostMapping("/add")
    public String addPersonSubmit(@ModelAttribute Person person){
        personService.createPerson(person);
        return "redirect:/person";
    }

    @GetMapping("/edit/{id}")
    public String editPersonForm(@PathVariable Long id, Model model){
        Person person = personService.getPersonById(id);
        model.addAttribute("person", person);
        return "person/edit-person";
    }

    @PostMapping("/edit/{id}")
    public String editPersonSubmit(@PathVariable Long id, @ModelAttribute Person person){
        personService.editPerson(id, person);
        return "redirect:/person";
    }

    @PostMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return "redirect:/person";
    }


}
