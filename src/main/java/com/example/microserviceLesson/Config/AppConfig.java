package com.example.microserviceLesson.Config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EnableFeignClients("com.example.microserviceLesson.feignClient")
public class AppConfig {
}
