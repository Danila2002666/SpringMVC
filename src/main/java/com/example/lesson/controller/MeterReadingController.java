package com.example.lesson.controller;


import com.example.lesson.models.Apartment;
import com.example.lesson.models.Meter;
import com.example.lesson.models.Person;
import com.example.lesson.service.MeterReadingService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/meter-readings")
public class MeterReadingController {

    private final MeterReadingService meterReadingService;


    @GetMapping
    public String showMeterReadingsForm(Model model) {
        Map<Apartment, List<Meter>> meters = meterReadingService.findPersonMeters();
        model.addAttribute("meters", meters);
        return "site/meter_readings";
    }

    @PostMapping("/save")
    public String saveMeterReadings(@RequestParam("meter1") String meter1,
                                    @RequestParam("meter2") String meter2) {
        // Сохранение показаний счетчиков в базу данных
        // Для этого вам может потребоваться использовать сервисы или репозитории
        return "redirect:/meter-readings";
    }
}