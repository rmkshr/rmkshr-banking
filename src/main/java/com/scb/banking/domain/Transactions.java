package com.scb.banking.domain;

import javax.persistence.*;

import com.scb.banking.repository.listeners.TransactionsListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ramkishore
 * The Transactions entity model
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(TransactionsListener.class)
@Table(name = "transactions")
public class Transactions implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_number", nullable = false)
    private Integer accountNumber;

    @Column(name = "transaction_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @Column(name = "transaction_details", nullable = false)
    private String transactionDetails;

    @Column(name = "currency_type", nullable = false)
    private String currencyType;

    @Column(name = "credit_amount")
    private long creditAmount;

    @Column(name = "debit_amount")
    private long debitAmount;

    @Column(name = "running_balance", nullable = false)
    private long runningBalance;

    @Column(name = "current_balance", nullable = false)
    private long currentBalance;

    @Column(name = "available_balance", nullable = false)
    private long availableBalance;

}
