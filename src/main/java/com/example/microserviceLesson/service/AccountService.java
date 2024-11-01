package com.example.microserviceLesson.service;


import com.example.microserviceLesson.dto.RegisterCheckRequest;
import com.example.microserviceLesson.dto.RegisterCheckResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountService {
    RegisterCheckResponse registerCheck(@RequestBody RegisterCheckRequest registerCheckRequest);
}
