package com.example.weatherapp;

import static org.mockito.ArgumentMatchers.eq;
import com.example.weatherapp.dto.WeatherResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherService weatherService;

    @BeforeEach
    public void setup() {
        // This method will be called before each test method and initialize the mocks.
    }

    @Test
    public void whenCalledGetWeatherForCity_thenRetrieveWeatherDetails() {
        // Creating a mock response to be returned when calling RestTemplate.
        WeatherResponse.Main mockMain = new WeatherResponse.Main();
        mockMain.setTemp(10.0);
        mockMain.setFeelsLike(8.0);

        WeatherResponse mockResponse = new WeatherResponse();
        mockResponse.setMain(mockMain);

        // RestTemplate mock behavior setting
        when(restTemplate.getForObject(anyString(), eq(WeatherResponse.class))).thenReturn(mockResponse);

        // Calling the method under test
        WeatherResponse result = weatherService.getWeatherForCity("Moscow");

        // Check the results
        assertEquals(10.0, result.getMain().getTemp());
        assertEquals(8.0, result.getMain().getFeelsLike());
    }
}
