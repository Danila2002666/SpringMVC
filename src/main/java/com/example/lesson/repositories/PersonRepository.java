package com.example.lesson.repositories;

import com.example.lesson.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);
    List<Person> findAllBy();
    Optional<Person> findByEmail(String email);
}
