package com.example.weatherAPI.data.controller;

import com.example.weatherAPI.data.dto.SensorDTO;
import com.example.weatherAPI.data.mapper.SensorMapper;
import com.example.weatherAPI.data.service.SensorService;
import com.example.weatherAPI.data.util.SensorValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sensors")
public class SensorController {


    private final SensorService sensorService;

    private final SensorValidator sensorValidator;

    @Autowired
    public SensorController(SensorService sensorService, SensorValidator sensorValidator) {
        this.sensorService = sensorService;
        this.sensorValidator = sensorValidator;
    }


    @GetMapping
    public List<SensorDTO> getSensors() {
        return sensorService.findAll().stream()
                .map(SensorMapper.INSTANCE::sensorToSensorDTO)
                .collect(Collectors.toList());
    }


    @PostMapping("/registration")
    public ResponseEntity<?> registrationSensor(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {

        sensorValidator.validate(sensorDTO,bindingResult);

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessages);
        }

        sensorService.save(SensorMapper.INSTANCE.sensorDTOToSensor(sensorDTO));
        return ResponseEntity.ok(sensorDTO);
    }

}
