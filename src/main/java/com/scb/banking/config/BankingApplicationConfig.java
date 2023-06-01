package com.scb.banking.config;

import com.scb.banking.service.AccountService;
import com.scb.banking.service.implementation.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankingApplicationConfig {

    @Bean
    public AccountService accountService(){
        return new AccountServiceImpl();
    }
}
