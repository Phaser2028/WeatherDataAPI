package com.example.weatherAPI.data.service.impl;

import com.example.weatherAPI.data.model.Measurement;
import com.example.weatherAPI.data.model.Sensor;
import com.example.weatherAPI.data.repository.MeasurementRepository;
import com.example.weatherAPI.data.service.MeasurementService;
import com.example.weatherAPI.data.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MeasurementServiceImpl implements MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    @Transactional
    public void save(Measurement measurement) {
        Optional<Sensor> sensor = sensorService.findByName(measurement.getSensor().getName());
        if (sensor.isPresent()) {
            measurement.setLocalDateTime(LocalDateTime.now());
            measurement.setSensor(sensor.get());
        }
//        else {
//            throw new SensorNotFoundException("Sensor with name " + measurement.getSensor().getName() + " not found.");
//        }
    }


    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }


}