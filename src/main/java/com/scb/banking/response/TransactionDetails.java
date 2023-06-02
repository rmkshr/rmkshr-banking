package com.scb.banking.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ramkishore
 * The transaction detials pojo class.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransactionDetails {

    @Id
    @JsonIgnore
    private Integer id;

    @JsonProperty("accountNumber")
    private Integer accountNumber;

    @JsonProperty("transactionDate")
    private Date transactionDate;

    @JsonProperty("transactionDetails")
    private String transactionDetails;

    @JsonProperty("currencyType")
    private String currencyType;

    @JsonProperty("creditAmount")
    private long creditAmount;

    @JsonProperty("debitAmount")
    private long debitAmount;

    @JsonProperty("runningBalance")
    private long runningBalance;

    @JsonProperty("currentBalance")
    @JsonIgnore
    private long currentBalance;

    @JsonProperty("availableBalance")
    @JsonIgnore
    private long availableBalance;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TransactionResponse{");
        sb.append("id=").append(id);
        sb.append(", accountNumber=").append(accountNumber);
        sb.append(", transactionDate=").append(transactionDate);
        sb.append(", transactionDetails='").append(transactionDetails).append('\'');
        sb.append(", currencyType='").append(currencyType).append('\'');
        sb.append(", creditAmount=").append(creditAmount);
        sb.append(", debitAmount=").append(debitAmount);
        sb.append(", runningBalance=").append(runningBalance);
        sb.append(", currentBalance=").append(currentBalance);
        sb.append(", availableBalance=").append(availableBalance);
        sb.append('}');
        return sb.toString();
    }
}
