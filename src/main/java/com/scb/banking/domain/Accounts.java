package com.scb.banking.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transactions> transactions;

}
