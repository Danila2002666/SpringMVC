package com.example.lesson.repository;

import com.example.lesson.models.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long> {
}
