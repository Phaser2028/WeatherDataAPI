package com.example.weatherAPI.data.mapper;

import com.example.weatherAPI.data.dto.SensorDTO;
import com.example.weatherAPI.data.model.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SensorMapper {
    SensorMapper INSTANCE = Mappers.getMapper(SensorMapper.class);

    SensorDTO sensorToSensorDTO(Sensor sensor);

    Sensor sensorDTOToSensor(SensorDTO sensorDTO);
}