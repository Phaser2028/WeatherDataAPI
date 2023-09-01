package com.example.weatherAPI.data.service;


import com.example.weatherAPI.data.model.Sensor;

import java.util.List;
import java.util.Optional;


public interface SensorService {
    Optional<Sensor> findByName(String name);

    List<Sensor> findAll();

    void save(Sensor sensor);
}
