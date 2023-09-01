package com.example.weatherAPI.data.service;


import com.example.weatherAPI.data.model.Measurement;

import java.util.List;


public interface MeasurementService{
    void save(Measurement measurement);
    List<Measurement> findAll();
}
