package com.example.weatherapp;

import org.springframework.http.ResponseEntity;
import com.example.weatherapp.dto.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
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


}
