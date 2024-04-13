package com.example.lesson.service;

import com.example.lesson.models.Apartment;
import com.example.lesson.models.Meter;
import com.example.lesson.models.Person;
import com.example.lesson.models.Reading;
import com.example.lesson.repository.ApartamentRepository;
import com.example.lesson.repository.MeterRepository;
import com.example.lesson.repository.PersonRepository;
import com.example.lesson.repository.ReadingsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Struct;
import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class MeterReadingService {

    private final MeterRepository meterRepository;
    private final ApartamentRepository apartamentRepository;
    private final PersonRepository personRepository;
    private final ReadingsRepository readingsRepository;

    public Map<Apartment, List<Meter>> findPersonMeters() {
        Map<Apartment, List<Meter>> allMeters = new HashMap<>();
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(email);
        Person person = personRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
        System.out.println(person);
        List<Apartment> apartments = apartamentRepository.findAllByPerson(person);
        System.out.println(apartments);
        for (Apartment apartment : apartments) {
            System.out.println(meterRepository.findAllByApartment(apartment));
            List<Meter> allByApartment = meterRepository.findAllByApartment(apartment);
            allMeters.put(apartment, allByApartment);
        }
        return allMeters;

    }
    public List<Reading> saveReading(Map<String,String> allReadings){
        List<Reading> readings = new ArrayList<>();
        // Итерация по ключам мапы и преобразование их в объекты Readin

        Iterator<Map.Entry<String, String>> itr = allReadings.entrySet().iterator();

        while(itr.hasNext()) {
           Map.Entry<String, String> entry =  itr.next();
           String counterNumber = entry.getKey();
           String value = entry.getValue();
           System.out.println(counterNumber + "   " + value);
           Meter meter = meterRepository.findAllByCounterNumber(Long.parseLong(counterNumber));
           Reading reading = new Reading();
           reading.setDate(LocalDate.now());
           reading.setMeter(meter);
           reading.setValue(new BigDecimal(value));
           readings.add(reading);
           readingsRepository.save(reading);
        }

        return readings;

    }
}
