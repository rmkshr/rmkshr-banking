package com.scb.banking.controller;

import com.scb.banking.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scb/accounts")
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllAccountDetails() {
        return ResponseEntity.ok(accountsRepository.findAll());
    }


}
