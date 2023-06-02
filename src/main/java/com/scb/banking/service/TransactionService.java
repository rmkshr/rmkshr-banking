package com.scb.banking.service;

import com.scb.banking.request.NewTransactionRequest;
import com.scb.banking.response.TransactionResponse;

/**
 * @author ramkishore
 */
public interface TransactionService {

    Long addNewTransaction(NewTransactionRequest newTransactionRequest) throws Exception;

    TransactionResponse getAllTransactions(Integer accountNumber);

}
