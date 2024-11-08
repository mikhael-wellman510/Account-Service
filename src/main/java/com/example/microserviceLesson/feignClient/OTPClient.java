package com.example.microserviceLesson.feignClient;

import com.example.microserviceLesson.dto.RegisterCheckRequest;
import com.example.microserviceLesson.dto.ResponseChecksDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//Panggil loaclhost service OTP
@FeignClient(name = "otp-service" )
public interface OTPClient {

    @PostMapping("/request")
    ResponseEntity<ResponseChecksDTO> requestOTP(@RequestBody RegisterCheckRequest registerCheckRequest);

    @GetMapping("/test-loadbalancer")
    String testLoadBalancer();
}
