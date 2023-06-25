package com.example.WeatherDataAPI.controllers;


import java.util.List;
import java.util.stream.Collectors;

import com.example.WeatherDataAPI.dto.MeasurementDTO;
import com.example.WeatherDataAPI.models.Measurement;
import com.example.WeatherDataAPI.services.MeasurementService;
import com.example.WeatherDataAPI.services.SensorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    private final MeasurementService measurementService;
    private final SensorService sensorService;

    @Autowired
    public MeasurementController(MeasurementService measurementService, SensorService sensorService) {
        this.measurementService = measurementService;
        this.sensorService = sensorService;
    }


    @GetMapping
    public List<MeasurementDTO> getMeasurements() {
        return measurementService.findAll().stream().map(this::convertToMeasurementDTO).collect(Collectors.toList());
    }

    @GetMapping("/getRainyDaysCount")
    public long getRainyDaysCount() {
        return measurementService.findAll().stream().filter(Measurement::isRaining).count();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> registrationSensor(@RequestBody MeasurementDTO measurementDTO) {

        measurementService.save(convertToMeasurement(measurementDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }


    private MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(measurement, MeasurementDTO.class);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Measurement measurement = modelMapper.map(measurementDTO, Measurement.class);

        return measurement;
    }
}
