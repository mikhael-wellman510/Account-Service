package com.example.microserviceLesson.dto;

public class OTPResponse {
    private String id;
    private String otp;
    private String email;

    @Override
    public String toString() {
        return "OTPResponse{" +
                "id='" + id + '\'' +
                ", otp='" + otp + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
