package com.example.weatherAPI.data.util;

import com.example.weatherAPI.data.dto.SensorDTO;
import com.example.weatherAPI.data.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {


    private final SensorService sensorService;

    public SensorValidator(@Autowired SensorService sensorService) {
        this.sensorService = sensorService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return SensorDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDTO sensorDTO = (SensorDTO) target;

        if (sensorService.findByName(sensorDTO.getName()).isPresent()) {
            errors.rejectValue("name", "SensorAlreadyExist", "Sensor with name "+sensorDTO.getName()+" already exists.");
        }
    }
}