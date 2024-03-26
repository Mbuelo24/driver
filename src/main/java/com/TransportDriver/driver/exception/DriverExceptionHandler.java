package com.TransportDriver.driver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DriverExceptionHandler {

    @ExceptionHandler(value = {DriverNotFoundException.class})
    public ResponseEntity<Object>  handleDriverNotFoundException
            (DriverNotFoundException driverNotFoundException)
    {
        DriverException driverException = new DriverException(
                driverNotFoundException.getMessage(),
                driverNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(driverException, HttpStatus.NOT_FOUND);
    }
}
