package com.scb.banking.service;

import com.scb.banking.domain.Accounts;

import java.util.List;

/**
 * @author ramkishore
 */
public interface AccountService {

    Integer createUserAccount(Integer accountTypeKey) throws Exception;

    List<Accounts> getAllUsers();
}
