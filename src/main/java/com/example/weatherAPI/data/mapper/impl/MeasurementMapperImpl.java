package com.example.weatherAPI.data.mapper.impl;

import com.example.weatherAPI.data.dto.MeasurementDTO;
import com.example.weatherAPI.data.mapper.MeasurementMapper;
import com.example.weatherAPI.data.model.Measurement;
import org.springframework.stereotype.Component;

@Component
public class MeasurementMapperImpl implements MeasurementMapper {
    @Override
    public MeasurementDTO measurementToMeasurementDTO(Measurement measurement) {
        return MeasurementMapper.INSTANCE.measurementToMeasurementDTO(measurement);
    }

    @Override
    public Measurement measurementDTOToMeasurement(MeasurementDTO measurementDTO) {
        return MeasurementMapper.INSTANCE.measurementDTOToMeasurement(measurementDTO);
    }
}
