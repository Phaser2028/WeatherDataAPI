package com.example.weatherAPI.data.mapper;

import com.example.weatherAPI.data.dto.MeasurementDTO;
import com.example.weatherAPI.data.model.Measurement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MeasurementMapper {
    MeasurementMapper INSTANCE = Mappers.getMapper(MeasurementMapper.class);

    MeasurementDTO measurementToMeasurementDTO(Measurement measurement);

    Measurement measurementDTOToMeasurement(MeasurementDTO measurementDTO);
}
