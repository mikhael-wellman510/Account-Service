package com.example.microserviceLesson.db.repository;

import com.example.microserviceLesson.db.entity.Account;
import com.example.microserviceLesson.db.entity.TempAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempAccountRepository extends CrudRepository<TempAccount, String> {
    TempAccount getFirstByEmail(String email);
}
