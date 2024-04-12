package com.example.lesson.repository;

import com.example.lesson.models.Meter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingsRepository extends JpaRepository<Meter,Long> {

}
