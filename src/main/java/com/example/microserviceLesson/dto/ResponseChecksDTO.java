package com.example.microserviceLesson.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ResponseChecksDTO {
    private String id;
    private String otp;
    private String email;

    @Override
    public String toString() {
        return "ResponseChecksDTO{" +
                "id='" + id + '\'' +
                ", otp='" + otp + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
