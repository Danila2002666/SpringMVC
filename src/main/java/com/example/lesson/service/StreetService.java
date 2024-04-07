package com.example.lesson.service;

import com.example.lesson.models.Street;
import com.example.lesson.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreetService {

    private final StreetRepository streetRepository;

    public List<Street> getAllStreets() {
        return streetRepository.findAll();
    }
}
