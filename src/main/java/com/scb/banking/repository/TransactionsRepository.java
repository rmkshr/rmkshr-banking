package com.scb.banking.repository;

import com.scb.banking.domain.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ramkishore
 * The transactions JPA repository
 */
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

    List<Transactions> findByAccountNumberOrderById(Integer accountNumber);

}
