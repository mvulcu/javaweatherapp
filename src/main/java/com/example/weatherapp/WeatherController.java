package com.example.weatherapp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import com.example.weatherapp.dto.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather/{city}")
    public ResponseEntity<WeatherResponse.Main> getWeather(@PathVariable String city) {
        WeatherResponse weatherResponse = weatherService.getWeatherForCity(city);
        return ResponseEntity.ok(weatherResponse.getMain()); // Возвращаем только часть данных, касающихся погоды
    }
    @GetMapping("/weather/view")
    public String viewWeather(@RequestParam("city") String city, Model model) {
        WeatherResponse weatherResponse = weatherService.getWeatherForCity(city);
        if (weatherResponse == null) {
            return "error"; // Имя шаблона страницы ошибки
        }
        // Если все в порядке, добавляем данные в модель и возвращаем шаблон с погодой
        model.addAttribute("city", city);
        model.addAttribute("temperature", weatherResponse.getMain().getTemp());
        model.addAttribute("feelsLike", weatherResponse.getMain().getFeelsLike());
        return "myweather";
    }



    @GetMapping("/weather")
    public String weatherForm() {
        return "weather"; // Возвращает имя начального шаблона с формой
    }


}
