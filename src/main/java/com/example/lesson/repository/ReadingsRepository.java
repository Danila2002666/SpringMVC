package com.example.lesson.repository;

import com.example.lesson.models.Meter;
import com.example.lesson.models.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingsRepository extends JpaRepository<Reading,Long> {



}
