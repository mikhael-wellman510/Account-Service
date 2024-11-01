package com.example.microserviceLesson.Exception;

public class ConflictException  extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}
