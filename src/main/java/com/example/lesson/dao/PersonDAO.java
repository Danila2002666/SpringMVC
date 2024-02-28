package com.example.lesson.dao;

import com.example.lesson.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    public PersonDAO() {
    }

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Danila"));
        people.add(new Person(++PEOPLE_COUNT,"Yna"));
        people.add(new Person(++PEOPLE_COUNT,"Ilia"));
        people.add(new Person(++PEOPLE_COUNT,"Vary"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
