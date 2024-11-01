package com.example.microserviceLesson.controller;

import com.example.microserviceLesson.dto.CommonResponse;
import com.example.microserviceLesson.dto.RegisterCheckRequest;
import com.example.microserviceLesson.dto.RegisterCheckResponse;
import com.example.microserviceLesson.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/check")
    public ResponseEntity<?> registerCheck(@RequestBody RegisterCheckRequest registerCheckRequest){
        RegisterCheckResponse registerCheckResponse = accountService.registerCheck(registerCheckRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<RegisterCheckResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Succes")
                        .data(registerCheckResponse)
                        .build()
                );
    }

}
