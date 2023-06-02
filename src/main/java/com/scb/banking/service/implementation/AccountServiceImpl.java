package com.scb.banking.service.implementation;

import com.scb.banking.domain.Accounts;
import com.scb.banking.enums.AccountTypeEnum;
import com.scb.banking.repository.AccountsRepository;
import com.scb.banking.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Random;

/**
 * @author ramkishore
 * The service implementation layer for accounts business logic
 */
@AllArgsConstructor
@NoArgsConstructor
public class AccountServiceImpl implements AccountService {

    private static final Integer MIN_RANGE = 0;
    private static final Integer MAX_RANGE = 99999999;

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public Integer createUserAccount(Integer accountTypeKey) throws Exception {
        try {
            Accounts accounts = new Accounts();
            accounts.setAccountNumber(generateAccountNumber());
            accounts.setAccountType(AccountTypeEnum.getAccountType(accountTypeKey));
            accounts.setAvailableBalance(0);
            accounts.setCurrentBalance(0);
            Accounts savedAccountDetails = accountsRepository.save(accounts);
            if (ObjectUtils.isEmpty(savedAccountDetails)) {
                throw new Exception("Error in creating account");
            }
            return savedAccountDetails.getAccountNumber();
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public List<Accounts> getAllUsers() {
        return accountsRepository.findAll();
    }

    public Integer generateAccountNumber() {
        Random random = new Random();
        return random.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;
    }
}
