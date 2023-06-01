package com.scb.banking.controller;

import com.scb.banking.repository.AccountsRepository;
import com.scb.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("scb/accounts")
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllAccountDetails() {
        return ResponseEntity.ok(accountService.getAllUsers());
    }

    @PostMapping("/create/{accountTypeKey}")
    public ResponseEntity<Integer> createCustomerAccount(@PathVariable Integer accountTypeKey) throws Exception {
        return ResponseEntity.ok(accountService.createUserAccount(accountTypeKey));
    }

}
