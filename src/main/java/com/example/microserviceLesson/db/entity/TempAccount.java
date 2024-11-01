package com.example.microserviceLesson.db.entity;


import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@RedisHash(value = "account" , timeToLive = 3600)
public class TempAccount {

    @Id
    private String id;
    private String email;
    private boolean valid = false;
}
