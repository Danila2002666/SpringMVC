package com.example.lesson.service;

import com.example.lesson.models.Apartment;
import com.example.lesson.models.Meter;
import com.example.lesson.models.Person;
import com.example.lesson.repository.ApartamentRepository;
import com.example.lesson.repository.MeterRepository;
import com.example.lesson.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MeterReadingService {

    private final MeterRepository meterRepository;
    private final ApartamentRepository apartamentRepository;
    private final PersonRepository personRepository;

    public Map<Apartment, List<Meter>> findPersonMeters() {
        Map<Apartment, List<Meter>> allMeters = new HashMap<>();
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Person person = personRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
        List<Apartment> apartments = apartamentRepository.findAllByPerson(person);
        for (Apartment apartment : apartments) {
            List<Meter> allByApartment = meterRepository.findAllByApartment(apartment);
            allMeters.put(apartment, allByApartment);
        }
        return allMeters;

    }
}
