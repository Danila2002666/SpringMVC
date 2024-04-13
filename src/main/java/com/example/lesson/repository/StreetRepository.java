package com.example.lesson.repository;

import com.example.lesson.models.Apartment;
import com.example.lesson.models.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Long> {

    public Street findAllById(Apartment apartment);
}
