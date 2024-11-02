package com.example.microserviceLesson.service;

import com.example.microserviceLesson.Exception.ConflictException;
import com.example.microserviceLesson.db.entity.Account;
import com.example.microserviceLesson.db.entity.TempAccount;
import com.example.microserviceLesson.db.repository.AccountRepository;
import com.example.microserviceLesson.db.repository.TempAccountRepository;
import com.example.microserviceLesson.dto.RegisterCheckRequest;
import com.example.microserviceLesson.dto.RegisterCheckResponse;
import com.example.microserviceLesson.dto.ResponseChecksDTO;
import com.example.microserviceLesson.feignClient.OTPClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final TempAccountRepository tempAccountRepository;
    private final OTPClient otpClient;
    @Override
    public RegisterCheckResponse registerCheck(RegisterCheckRequest registerCheckRequest) {
        String email = registerCheckRequest.getEmail();
        // Todo -> Check data di postgres
        Account accountByEmail = accountRepository.getFirstByEmail(email);

        // Todo -> jika akun sudah ada
        if(accountByEmail != null){
            throw new ConflictException("Conflict Bos");
        }

        TempAccount tempAccountByEmail = tempAccountRepository.getFirstByEmail(email);

        // Todo -> Kalau akun sudah ada . maka tampilkan
        if (tempAccountByEmail != null) return RegisterCheckResponse.builder()
                .email(tempAccountByEmail.getEmail())
                .build();

        TempAccount saveAccount =  TempAccount.builder()
                .email(registerCheckRequest.getEmail())
                .valid(false)
                .build();
        // Todo -> Kalau account belum ada , maka save

        tempAccountRepository.save(saveAccount);


        // Request OTP

        try{
            ResponseEntity<ResponseChecksDTO> responseEntity = otpClient.requestOTP(registerCheckRequest);

            System.out.println(responseEntity);
            System.out.println("hahah " + responseEntity.getBody());

            return RegisterCheckResponse.builder()
                    .email(saveAccount.getEmail())

                    .build();
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }


    }
}
