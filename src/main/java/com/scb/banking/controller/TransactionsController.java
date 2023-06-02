package com.scb.banking.controller;

import com.scb.banking.request.NewTransactionRequest;
import com.scb.banking.response.TransactionResponse;
import com.scb.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ramkishore
 * This controller contains the enpoints for transaction related actions
 */
@RestController
@RequestMapping("scb/transactions")
public class TransactionsController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<Long> createCustomerAccount(@RequestBody NewTransactionRequest request) throws Exception {
        return ResponseEntity.ok(transactionService.addNewTransaction(request));
    }

    @GetMapping("/all/{accountNumber}")
    public ResponseEntity<TransactionResponse> getAllAccountDetails(@PathVariable Integer accountNumber) {
        return ResponseEntity.ok(transactionService.getAllTransactions(accountNumber));
    }

}
