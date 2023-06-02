package com.scb.banking.config;

import com.scb.banking.service.AccountService;
import com.scb.banking.service.TransactionService;
import com.scb.banking.service.implementation.AccountServiceImpl;
import com.scb.banking.service.implementation.TransactionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ramkishore
 * This class contains all the bean configurations common to the application.
 */
@Configuration
public class BankingApplicationConfig {

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl();
    }

    @Bean
    public TransactionService transactionService() {
        return new TransactionServiceImpl();
    }

}
