package com.example.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Ignore unknown properties to avoid deserialization errors
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    // Internal static class to map to the "main" object in the JSON response
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

    // Getters and Setters for external class
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
