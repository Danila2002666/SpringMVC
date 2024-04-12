package com.example.lesson.repository;

import com.example.lesson.models.Apartment;
import com.example.lesson.models.Meter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeterRepository extends JpaRepository<Meter, Long> {
    List<Meter> findAllByApartment(Apartment apartment);
}
