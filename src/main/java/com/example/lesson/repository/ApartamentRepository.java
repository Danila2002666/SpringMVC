package com.example.lesson.repository;

import com.example.lesson.models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentRepository extends JpaRepository<Apartment, Long> {

}
