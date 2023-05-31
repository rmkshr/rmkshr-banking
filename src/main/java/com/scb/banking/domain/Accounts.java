package com.scb.banking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Accounts implements Serializable {

    @Id
    @Column(name = "account_number", nullable = false)
    private Integer accountNumber;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(name = "available_balance", nullable = false)
    private long availableBalance;

    @Column(name = "current_balance", nullable = false)
    private long currentBalance;
}
