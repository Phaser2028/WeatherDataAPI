package com.example.WeatherDataAPI.dto;


import com.example.WeatherDataAPI.models.Sensor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
public class MeasurementDTO {


    @NotEmpty(message = "это поле не должно быть пустым")
    @Min(value = -100, message = "-100 -минимальное значение")
    @Max(value = 100,message = "100 - максимальное значение")
    private float value;

    @NotEmpty(message = "это поле не должно быть пустым")
    private boolean raining;

    @NotEmpty(message = "это поле не должно быть пустым")
    private SensorDTO sensor;


}
