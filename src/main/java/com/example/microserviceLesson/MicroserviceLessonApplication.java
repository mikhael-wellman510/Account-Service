package com.example.microserviceLesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

public class MicroserviceLessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceLessonApplication.class, args);
		System.out.println("Server Running in 8010");
	}

}
