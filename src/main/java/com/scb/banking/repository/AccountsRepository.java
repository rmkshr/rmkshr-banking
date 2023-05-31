package com.scb.banking.repository;

import com.scb.banking.domain.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
    List<Accounts> findAll();
}
