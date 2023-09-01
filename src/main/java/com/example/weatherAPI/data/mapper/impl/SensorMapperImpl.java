package com.example.weatherAPI.data.mapper.impl;

import com.example.weatherAPI.data.dto.SensorDTO;
import com.example.weatherAPI.data.mapper.SensorMapper;
import com.example.weatherAPI.data.model.Sensor;
import org.springframework.stereotype.Component;

@Component
public class SensorMapperImpl implements SensorMapper {
    @Override
    public SensorDTO sensorToSensorDTO(Sensor sensor) {
        return SensorMapper.INSTANCE.sensorToSensorDTO(sensor);
    }

    @Override
    public Sensor sensorDTOToSensor(SensorDTO sensorDTO) {
        return SensorMapper.INSTANCE.sensorDTOToSensor(sensorDTO);
    }
}
