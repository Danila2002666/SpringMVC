package com.example.lesson.repository;

import com.example.lesson.models.Apartment;
import com.example.lesson.models.Person;
import com.example.lesson.models.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StreetRepository extends JpaRepository<Street, Long> {

    public Street findAllById(Apartment apartment);

    public Street findAllById(Long id);

    public Street findByApartments(Apartment apartment);

}



