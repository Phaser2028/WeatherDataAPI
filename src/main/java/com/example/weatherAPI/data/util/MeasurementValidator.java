package com.example.weatherAPI.data.util;


import com.example.weatherAPI.data.dto.MeasurementDTO;
import com.example.weatherAPI.data.model.Sensor;
import com.example.weatherAPI.data.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class MeasurementValidator  implements Validator {

    @Autowired
    private SensorService sensorService;

    @Override
    public boolean supports(Class<?> clazz) {
        return MeasurementDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeasurementDTO measurementDTO = (MeasurementDTO) target;
        Optional<Sensor> optionalSensor = sensorService.findByName(measurementDTO.getSensor().getName());

        if (optionalSensor.isEmpty()) {
            errors.rejectValue("sensor", "SensorNotFound", "Sensor with name "+measurementDTO.getSensor().getName()+" not found.");
        }
    }
}
