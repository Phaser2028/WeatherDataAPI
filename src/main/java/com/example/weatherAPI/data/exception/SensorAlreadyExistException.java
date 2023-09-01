package com.example.weatherAPI.data.exception;

public class SensorAlreadyExistException extends RuntimeException{
    public SensorAlreadyExistException(String message) {
        super(message);
    }
}
