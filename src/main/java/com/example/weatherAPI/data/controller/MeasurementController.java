package com.example.weatherAPI.data.controller;


import com.example.weatherAPI.data.dto.MeasurementDTO;
import com.example.weatherAPI.data.mapper.MeasurementMapper;
import com.example.weatherAPI.data.model.Measurement;
import com.example.weatherAPI.data.service.MeasurementService;
import com.example.weatherAPI.data.util.MeasurementValidator;
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
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;
    private final MeasurementValidator measurementValidator;

    @Autowired
    public MeasurementController(MeasurementService measurementService, MeasurementValidator measurementValidator) {
        this.measurementService = measurementService;
        this.measurementValidator = measurementValidator;
    }


    @GetMapping
    public List<MeasurementDTO> getMeasurements() {
        return measurementService.findAll().stream()
                .map(MeasurementMapper.INSTANCE::measurementToMeasurementDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/getRainyDaysCount")
    public long getRainyDaysCount() {
        return measurementService.findAll().stream()
                .filter(Measurement::getRaining)
                .count();
    }

    @PostMapping("/add")
    public ResponseEntity<?> registrationMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO, BindingResult bindingResult) {

        measurementValidator.validate(measurementDTO,bindingResult);

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessages);
        }

        measurementService.save(MeasurementMapper.INSTANCE.measurementDTOToMeasurement(measurementDTO));
        return ResponseEntity.ok(measurementDTO);
    }

}
