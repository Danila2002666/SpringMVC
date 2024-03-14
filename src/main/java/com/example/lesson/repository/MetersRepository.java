package com.example.lesson.repository;

import com.example.lesson.models.Meters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetersRepository extends JpaRepository<Meters, Long> {
}
