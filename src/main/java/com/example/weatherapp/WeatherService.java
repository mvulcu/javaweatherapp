package com.example.weatherapp;

import com.example.weatherapp.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${app.weather.api.key}")
    private String apiKey;

    private final String apiUrl = "http://api.openweathermap.org/data/2.5/weather";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeatherForCity(String city) {
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric"; // Добавлен параметр units=metric для получения температуры в Цельсиях
        return restTemplate.getForObject(url, WeatherResponse.class);
    }


}
