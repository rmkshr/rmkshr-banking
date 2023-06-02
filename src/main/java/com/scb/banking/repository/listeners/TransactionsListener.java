package com.scb.banking.repository.listeners;


import com.scb.banking.domain.Accounts;
import com.scb.banking.domain.Transactions;
import com.scb.banking.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PrePersist;

/**
 * @author ramkishore
 * The JPA event listener for transactions entity.
 */
public class TransactionsListener {

    private static AccountsRepository accountsRepository;

    @Autowired
    public void setEntityRepository(AccountsRepository accountsRepository) {
        TransactionsListener.accountsRepository = accountsRepository;
    }

    @PrePersist
    public void updateAccountsAvailableBalance(Transactions transactions) {
        Accounts accounts = new Accounts();
        String accountType = accountsRepository.findAccountType(transactions.getAccountNumber());
        accounts.setAccountNumber(transactions.getAccountNumber());
        accounts.setAccountType(accountType);
        accounts.setAvailableBalance(transactions.getAvailableBalance());
        accounts.setCurrentBalance(transactions.getCurrentBalance());
        accountsRepository.save(accounts);
    }
}
