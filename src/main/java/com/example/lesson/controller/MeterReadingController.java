package com.example.lesson.controller;

import com.example.lesson.models.Apartment;
import com.example.lesson.models.Meter;
import com.example.lesson.service.MeterReadingService;
import com.example.lesson.service.StreetService;
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
    private final StreetService streetService;


    @PostMapping("/add")
    public String submitMeterReadings(@RequestParam Map<String,String> allParams) {
        meterReadingService.saveReading(allParams);
        return "redirect:/meter-readings";
    }
    @GetMapping()
    public String showMeterReadingsForm(Model model) {
        Map<Apartment, List<Meter>> meters = meterReadingService.findPersonMeters();
//      List<Street> street = streetService.getStreetHashMap(meters);
        model.addAttribute("meters", meters);
//      model.addAttribute("street", street);
        return "site/meter_readings";
    }


}