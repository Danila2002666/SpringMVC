package com.example.lesson.repository;

import com.example.lesson.models.Apartment;
import com.example.lesson.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartamentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findAllByPerson(Person person);

}
