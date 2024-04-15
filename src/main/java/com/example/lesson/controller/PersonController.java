package com.example.lesson.controller;

import com.example.lesson.models.Apartment;
import com.example.lesson.models.Person;
import com.example.lesson.models.Street;
import com.example.lesson.service.ApartmentService;
import com.example.lesson.service.PersonService;
import com.example.lesson.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final ApartmentService apartmentService;
    private final StreetService streetService;

    @GetMapping("/main")
    public String mainUser(Model model) {

        Person user = personService.getUser();
        List<Apartment> apartments = apartmentService.getApartmentsByPerson();
        Map<Apartment, Street> apartmentsWithStreets = streetService.getAllStreetByApartments(apartments);
        model.addAttribute("apartmentsWithStreets", apartmentsWithStreets);
        model.addAttribute("user",user);
        return "site/main";
    }


    @GetMapping
    public String listPerson(Model model) {
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        Person user = personService.getUser();
        model.addAttribute("user",user);


        return "person/person";
    }

    @GetMapping("/add")
    public String addPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "person/add-person";
    }

    @PostMapping("/add")
    public String addPersonSubmit(@ModelAttribute Person person) {
        personService.createPerson(person);
        return "redirect:/person";
    }

    @GetMapping("/edit/{id}")
    public String editPersonForm(@PathVariable Long id, Model model) {
        Person person = personService.getPersonById(id);
        model.addAttribute("person", person);
        return "person/edit-person";
    }

    @PostMapping("/edit/{id}")
    public String editPersonSubmit(@PathVariable Long id, @ModelAttribute Person person) {
        personService.editPerson(id, person);
        return "redirect:/person";
    }

    @PostMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "redirect:/person";
    }
}
