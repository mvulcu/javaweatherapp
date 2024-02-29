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
        // Этот метод будет вызван перед каждым тестовым методом и инициализирует моки
    }

    @Test
    public void whenCalledGetWeatherForCity_thenRetrieveWeatherDetails() {
        // Создание мокового ответа, который будет возвращаться при вызове RestTemplate
        WeatherResponse.Main mockMain = new WeatherResponse.Main();
        mockMain.setTemp(10.0);
        mockMain.setFeelsLike(8.0);

        WeatherResponse mockResponse = new WeatherResponse();
        mockResponse.setMain(mockMain);

        // Настройка мокового поведения RestTemplate
        when(restTemplate.getForObject(anyString(), eq(WeatherResponse.class))).thenReturn(mockResponse);

        // Вызов тестируемого метода
        WeatherResponse result = weatherService.getWeatherForCity("Moscow");

        // Проверка результатов
        assertEquals(10.0, result.getMain().getTemp());
        assertEquals(8.0, result.getMain().getFeelsLike());
    }
}
