package com.example.microserviceLesson.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegisterCheckDTO {
    private String email;
}
