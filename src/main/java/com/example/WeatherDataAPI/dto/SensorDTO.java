package com.example.WeatherDataAPI.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
public class SensorDTO {

    @UniqueElements(message = "такой сенсор уже существует")
    @NotEmpty(message = "это поле не должно быть пустым")
    private String name;

}
