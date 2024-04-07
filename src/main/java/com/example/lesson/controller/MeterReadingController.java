package com.example.lesson.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/meter-readings")
public class MeterReadingController {

    @RestController
    @RequestMapping("/api")
    public class MeterReadingController {

        @GetMapping("/meter_reading")
        public UserModel getMeterReading() {
            // Предположим, что у вас есть сервис, который возвращает данные пользователя и номера счетчиков
            UserService userService = new UserService();
            User user = userService.getCurrentUser();

            // Создаем модель с данными пользователя и номерами счетчиков
            UserModel userModel = new UserModel();
            userModel.setUserName(user.getName());
            userModel.setUserAddress(user.getAddress());
            userModel.setMeterNumbers(user.getMeterNumbers());

            return userModel;
        }
    }
    @GetMapping
    public String showMeterReadingsForm() {
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