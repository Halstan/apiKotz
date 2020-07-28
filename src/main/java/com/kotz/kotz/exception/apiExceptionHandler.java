package com.kotz.kotz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class apiExceptionHandler {

    @ExceptionHandler(value = {apiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(apiRequestException e){
        apiException apiException = new apiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("UTC-5"))
        );

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}
