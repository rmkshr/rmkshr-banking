package com.scb.banking.config;

import com.scb.banking.repository.AccountsRepository;
import com.scb.banking.repository.listeners.TransactionsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ramkishore
 * This class contains the JPA listener bean config for Transactions entity.
 */
@Configuration
public class TransactionListenerConfig {

    @Autowired
    private AccountsRepository accountsRepository;

    @Bean
    public TransactionsListener transactionsListener() {
        TransactionsListener transactionsListener = new TransactionsListener();
        transactionsListener.setEntityRepository(accountsRepository);
        return transactionsListener;
    }

}
