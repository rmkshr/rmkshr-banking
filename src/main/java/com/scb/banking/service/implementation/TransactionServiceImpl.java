package com.scb.banking.service.implementation;

import com.scb.banking.domain.Transactions;
import com.scb.banking.repository.AccountsRepository;
import com.scb.banking.repository.TransactionsRepository;
import com.scb.banking.request.NewTransactionRequest;
import com.scb.banking.response.TransactionDetails;
import com.scb.banking.response.TransactionResponse;
import com.scb.banking.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ramkishore
 * The service implementation layer for transactions business logic
 */
@AllArgsConstructor
@NoArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private AccountsRepository accountsRepository;

    /**
     * Function used to add new transaction for a customer account.
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public Long addNewTransaction(NewTransactionRequest request) throws Exception {
        try {
            Transactions transactions = new Transactions();
            List<Integer> accountNumbers = accountsRepository.findAllPrimaryKeys();
            if (!accountNumbers.contains(request.getAccountNumber())) {
                throw new Exception("Invalid Account number / Account does not exist");
            }
            Long availableBalance = accountsRepository.findAvailableBalanceByAccountNumber(request.getAccountNumber());
            transactions.setAccountNumber(request.getAccountNumber());
            transactions.setTransactionDate(new Date());
            transactions.setTransactionDetails(request.getTransactionDetails());
            transactions.setCurrencyType(request.getCurrencyType());
            if (request.getCreditAmount() == 0) {
                transactions.setRunningBalance(availableBalance - request.getDebitAmount());
                transactions.setDebitAmount(request.getDebitAmount());
            } else if (request.getDebitAmount() == 0) {
                transactions.setRunningBalance(availableBalance + request.getCreditAmount());
                transactions.setCreditAmount(request.getCreditAmount());
            } else {
                throw new Exception("Both Credit and Debit amount cannot be 0.");
            }
            transactions.setAvailableBalance(transactions.getRunningBalance());
            transactions.setCurrentBalance(transactions.getRunningBalance());
            transactionsRepository.save(transactions);
            return transactions.getAvailableBalance();
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Function used to get all transactions for a given account number.
     * @param accountNumber
     * @return
     */
    @Override
    public TransactionResponse getAllTransactions(Integer accountNumber) {
        TransactionResponse transactionResponse = new TransactionResponse();
        List<TransactionDetails> transactionDetailsList = copyList(transactionsRepository.findByAccountNumberOrderById(accountNumber), TransactionDetails.class);
        transactionResponse.setTransactionDetailsList(transactionDetailsList);
        int transactionCount = transactionDetailsList.size();
        transactionResponse.setAvailableBalance(transactionDetailsList.get(transactionCount - 1).getRunningBalance());
        transactionResponse.setCurrentBalance(transactionDetailsList.get(transactionCount - 1).getRunningBalance());
        return transactionResponse;
    }

    /**
     * Function to copy objects.
     * @param sourceList
     * @param targetClass
     * @return
     * @param <T>
     */
    public <T> List<T> copyList(List<?> sourceList, Class<T> targetClass) {
        List<T> targetList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            T targetObject;
            try {
                targetObject = targetClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Error creating target object", e);
            }
            BeanUtils.copyProperties(sourceObject, targetObject);
            targetList.add(targetObject);
        }
        return targetList;
    }
}
