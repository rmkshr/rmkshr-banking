package com.scb.banking.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NewTransactionRequest implements Serializable {
    @Id
    private Integer id;

    @JsonProperty("accountNumber")
    private Integer accountNumber;

    @JsonProperty("transactionDetails")
    private String transactionDetails;

    @JsonProperty("currencyType")
    private String currencyType;

    @JsonProperty("creditAmount")
    private long creditAmount;

    @JsonProperty("debitAmount")
    private long debitAmount;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewTransactionRequest{");
        sb.append("id=").append(id);
        sb.append(", accountNumber=").append(accountNumber);
        sb.append(", transactionDetails='").append(transactionDetails).append('\'');
        sb.append(", currencyType='").append(currencyType).append('\'');
        sb.append(", creditAmount=").append(creditAmount);
        sb.append(", debitAmount=").append(debitAmount);
        sb.append('}');
        return sb.toString();
    }
}
