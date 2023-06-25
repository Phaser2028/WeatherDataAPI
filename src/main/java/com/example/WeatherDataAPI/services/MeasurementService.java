package com.example.WeatherDataAPI.services;


import com.example.WeatherDataAPI.models.Measurement;
import com.example.WeatherDataAPI.models.Sensor;
import com.example.WeatherDataAPI.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    @Transactional
    public void save(Measurement measurement){
        measurement.setLocalDateTime(LocalDateTime.now());
        measurement.setSensor(sensorService.findOne(measurement.getSensor().getName()));
        measurementRepository.save(measurement);
    }


    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }
    

}
