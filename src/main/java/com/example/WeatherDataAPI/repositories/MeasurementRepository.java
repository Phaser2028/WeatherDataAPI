package com.example.WeatherDataAPI.repositories;

import com.example.WeatherDataAPI.models.Measurement;
import com.example.WeatherDataAPI.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    List<Measurement> findBySensor(Sensor sensor);

}
