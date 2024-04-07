package com.example.lesson.service;

import com.example.lesson.models.Apartment;
import com.example.lesson.models.Person;
import com.example.lesson.repository.ApartamentRepository;
import com.example.lesson.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApartmentService {

    private final ApartamentRepository apartamentRepository;
    private final PersonRepository personRepository;

    public List<Apartment> getAllApartment() {
        return apartamentRepository.findAll();
    }

    public void createApartment(Apartment apartment) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Person person = personRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
        apartment.setPerson(person);
        apartamentRepository.save(apartment);
    }
}
