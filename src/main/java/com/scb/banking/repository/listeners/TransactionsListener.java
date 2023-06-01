package com.scb.banking.repository.listeners;


import com.scb.banking.domain.Accounts;
import com.scb.banking.domain.Transactions;
import com.scb.banking.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostUpdate;

public class TransactionsListener {

    @Autowired
    private AccountsRepository accountsRepository;

    @PostUpdate
    public void updateAccountsAvailableBalance(Transactions transactions) {
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(transactions.getAccountNumber());
        accounts.setAvailableBalance(transactions.getAvailableBalance());
        accounts.setCurrentBalance(transactions.getCurrentBalance());
        accountsRepository.save(accounts);
    }
}
