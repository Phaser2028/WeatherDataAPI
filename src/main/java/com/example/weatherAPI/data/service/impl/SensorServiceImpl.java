package com.example.weatherAPI.data.service.impl;

import com.example.weatherAPI.data.model.Sensor;
import com.example.weatherAPI.data.repository.SensorRepository;
import com.example.weatherAPI.data.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;


    public SensorServiceImpl(@Autowired SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    @Override
    public Optional<Sensor> findByName(String name) {
        return sensorRepository.findByName(name);
    }

    @Override
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Sensor sensor) {
        //???
//        Optional<Sensor> optionalSensor = sensorRepository.findByName(sensor.getName());
//        if(optionalSensor.isPresent()){
//            throw new SensorAlreadyExistException("Sensor with name "+sensor.getName() +" already exist.");
//        }
        sensorRepository.save(sensor);
    }

}
