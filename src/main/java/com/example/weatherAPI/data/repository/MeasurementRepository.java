package com.example.weatherAPI.data.repository;

import com.example.weatherAPI.data.model.Measurement;
import com.example.weatherAPI.data.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    List<Measurement> findBySensor(Sensor sensor);

    List<Measurement> findBySensorName(String name);

}
