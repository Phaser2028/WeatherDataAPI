package com.example.weatherAPI.data.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementDTO {


    @NotEmpty(message = "Value field should not be empty.")
    @Min(value = -100, message = "-100 is the min value.")
    @Max(value = 100,message = "100 is the max value.")
    private Float value;

    @NotEmpty(message = "Raining field should not be empty.")
    private Boolean raining;

    @NotEmpty(message = "Sensor field should not be empty.")
    private SensorDTO sensor;


}
