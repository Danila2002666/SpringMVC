package com.example.lesson.service;

import com.example.lesson.models.Person;
import com.example.lesson.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
    }

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public void editPerson(Long id, Person updatedPerson) {
        Person person = getPersonById(id);
        person.setName(updatedPerson.getName());
        person.setLastName(updatedPerson.getLastName());
        person.setPostName(updatedPerson.getPostName());
        person.setNumber(updatedPerson.getNumber());
        person.setEmail(updatedPerson.getEmail());
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

}
