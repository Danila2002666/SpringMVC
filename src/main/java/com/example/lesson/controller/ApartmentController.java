package com.example.lesson.controller;

import com.example.lesson.models.Apartment;
import com.example.lesson.service.ApartmentService;
import com.example.lesson.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;
    private final StreetService streetService;

    @GetMapping
    public String listApartment(Model model) {
        List<Apartment> apartments = apartmentService.getAllApartment();
        model.addAttribute("apartments", apartments);
        return "apartment/apartments";
    }

    @GetMapping("/add")
    public String addApartmentForm(Model model) {
        model.addAttribute("apartment", new Apartment());
        model.addAttribute("streets", streetService.getAllStreets());
        return "apartment/add-apartment";
    }

    @PostMapping("/add")
    public String addApartmentSubmit(@ModelAttribute Apartment apartment) {
        apartmentService.createApartment(apartment);
        return "redirect:/apartment";
    }
}
