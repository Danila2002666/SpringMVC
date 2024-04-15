package com.example.lesson.repository;

import com.example.lesson.models.Meter;
import com.example.lesson.models.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingsRepository extends JpaRepository<Reading,Long> {

    public List<Reading> findAllByMeter(Meter meter);


}
