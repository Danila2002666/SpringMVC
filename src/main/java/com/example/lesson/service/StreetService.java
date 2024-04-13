package com.example.lesson.service;

import com.example.lesson.models.Apartment;
import com.example.lesson.models.Meter;
import com.example.lesson.models.Street;
import com.example.lesson.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StreetService {

    private final StreetRepository streetRepository;

    public List<Street> getAllStreets() {
        return streetRepository.findAll();
    }
    public List<Street> getStreetHashMap(Map<Apartment, List<Meter>> meters) {
        List<Street> streets = new ArrayList<>();
        Set<Apartment> setKeys = meters.keySet();
        for(Apartment apartment: setKeys){
            streets.add(streetRepository.findAllById(apartment));
        }
        return  streets;
    }


}
