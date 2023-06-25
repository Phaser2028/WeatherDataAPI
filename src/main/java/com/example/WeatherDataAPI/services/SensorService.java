package com.example.WeatherDataAPI.services;


import com.example.WeatherDataAPI.models.Sensor;
import com.example.WeatherDataAPI.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Sensor findOne(int id){
        return sensorRepository.findById(id).orElse(null);
    }

    public Sensor findOne(String name){
        return sensorRepository.findByName(name);
    }

    public List<Sensor> findAll(){
        return sensorRepository.findAll();
    }
    @Transactional
    public void save(Sensor sensor){
        sensorRepository.save(sensor);
    }

}
