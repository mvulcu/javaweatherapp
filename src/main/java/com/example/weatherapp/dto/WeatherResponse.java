package com.example.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Игнорируем неизвестные свойства для того, чтобы избежать ошибок при десериализации
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    // Внутренний статический класс для сопоставления с объектом "main" в JSON ответе
    public static class Main {

        @JsonProperty("temp")
        private double temp;

        @JsonProperty("feels_like")
        private double feelsLike;

        // Getters и Setters
        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(double feelsLike) {
            this.feelsLike = feelsLike;
        }
    }

    @JsonProperty("main")
    private Main main;

    // Getters и Setters для внешнего класса
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
