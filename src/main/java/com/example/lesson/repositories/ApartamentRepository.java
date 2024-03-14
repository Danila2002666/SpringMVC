package com.example.lesson.repositories;

import com.example.lesson.models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentRepository extends JpaRepository<Apartment, Long> {

}
