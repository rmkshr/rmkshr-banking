package com.scb.banking.repository;

import com.scb.banking.domain.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ramkishore
 * The accounts JPA repository
 */
@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
    List<Accounts> findAll();

    @Query("SELECT a.availableBalance FROM Accounts a WHERE a.accountNumber = :accountNumber")
    Long findAvailableBalanceByAccountNumber(Integer accountNumber);

    @Query("SELECT accounts.accountNumber FROM Accounts accounts")
    List<Integer> findAllPrimaryKeys();

    @Query("SELECT a.accountType FROM Accounts a WHERE a.accountNumber = :accountNumber")
    String findAccountType(Integer accountNumber);
}
