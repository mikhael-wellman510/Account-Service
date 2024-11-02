package com.example.microserviceLesson.Exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data Not Found : "+ e);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handleConflictException(ConflictException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict occurred: " + ex.getMessage());
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException ex) {
        // Mengambil status dan pesan dari FeignException
        HttpStatus status = HttpStatus.valueOf(ex.status());
        String message = "Feign Client Error: " + ex.getMessage();

        return ResponseEntity.status(status).body(message);
    }
}
